package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import beans.Customer;
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
		if(action == null)
		{
			
		}
		else if (action == "showBilling")
		{
			List<Address> listA  = new ArrayList<Address>();
			
		    request.setAttribute("AddressesList", listA);
		    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/AddressesView.jsp");
	        dispatcher.forward(request, response);
	        
		}
		else if(action == "showShipping")
		{
			List<Address> listA  = new ArrayList<Address>();
			
		    request.setAttribute("AddressesList", listA);
		    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/AddressesView.jsp");
	        dispatcher.forward(request, response);
		}
		
		
		
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



}
