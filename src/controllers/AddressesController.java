package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import beans.Customer;
import services.AddressesFromServer;
import services.ClientInterface;
import beans.Address;
/**
 * Servlet implementation class AddressesController
 */

public class AddressesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{	
			request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
		}
		
		int idcust =(int)session.getAttribute("user_id"); 
		
		try 
		{
			if (action.equals("showBilling"))
			{
				List<Address> listA  = AddressesFromServer.findAll(idcust, "billing", ClientInterface.findAuthToken(request));
			
				request.setAttribute("AddressesList", listA);
				request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
	        
			}	
			else if(action.equals("showShipping"))
			{
				List<Address> listA  = AddressesFromServer.findAll(idcust, "shipping", ClientInterface.findAuthToken(request));
			
				request.setAttribute("AddressesList", listA);
				request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
				
			}
			else if (action.equals("delete"))
			{
				int idadd = Integer.parseInt(request.getParameter("id"));
				
				AddressesFromServer.delete(idcust, idadd, ClientInterface.findAuthToken(request));
				
				List<Address> listA = AddressesFromServer.findAll(idcust, "billing", ClientInterface.findAuthToken(request));
				
				request.setAttribute("AddressesList", listA);
				request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
				
			}
			else if(action.equals("edit"))
			{
				int idadd = Integer.parseInt(request.getParameter("id"));
				
				Address address = AddressesFromServer.find(idcust, idadd, ClientInterface.findAuthToken(request));
				
				request.setAttribute("Address", address);
				request.getRequestDispatcher("AddressesEdit.jsp").forward(request,response);
				
			}
		} catch (RuntimeException e) {
			String error  =  "Something went wrong with the server. Please contact the website administrator for further information...";
			Address address = null;
			request.setAttribute("Address", address);
			request.setAttribute("Error", error);
			request.getRequestDispatcher("AddressesEdit.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try 
		{
		HttpSession session = request.getSession(false);
		
		if(session==null || (session != null && session.getAttribute("user_id")== null))
		{	
			request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
	
		}
		
		int idcust =(int)session.getAttribute("user_id"); 
		
		String typeaction = request.getParameter("typeaction");
		
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String type = request.getParameter("type");
		
		if(typeaction.equals("add"))
		{
			AddressesFromServer.create(idcust, address, zipcode, city, country, type, ClientInterface.findAuthToken(request));
		}
		if(typeaction.equals("update"))
		{
			int idadd = Integer.parseInt(request.getParameter("idaddress"));
			AddressesFromServer.update(idcust, idadd, address, zipcode, city, country, type, ClientInterface.findAuthToken(request));
		}
		
		
		List<Address> listA = AddressesFromServer.findAll(idcust, "shipping", ClientInterface.findAuthToken(request));
		
		request.setAttribute("AddressesList", listA);
		request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
