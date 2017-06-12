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
				List<Address> listA  = AddressesFromServer.findAll(idcust, "billing");
			
				request.setAttribute("AddressesList", listA);
				request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
	        
			}	
			else if(action.equals("showShipping"))
			{
				List<Address> listA  = AddressesFromServer.findAll(idcust, "shipping");
			
				request.setAttribute("AddressesList", listA);
				request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
				
			}
			else if (action.equals("delete"))
			{
				int idadd = Integer.parseInt(request.getParameter("id"));
				
				AddressesFromServer.delete(idcust, idadd);
				
				List<Address> listA = AddressesFromServer.findAll(idcust, "billing");
				
				request.setAttribute("AddressesList", listA);
				request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
				
			}
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
		doGet(request, response);
		try 
		{
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{	
			request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
		}
		
		int idcust =(int)session.getAttribute("user_id"); 
		
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String type = request.getParameter("type");
		
		
		AddressesFromServer.create(idcust, address, zipcode, city, country, type);
		
		List<Address> listA = AddressesFromServer.findAll(idcust, "shipping");
		
		request.setAttribute("AddressesList", listA);
		request.getRequestDispatcher("AddressesView.jsp").forward(request,response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
