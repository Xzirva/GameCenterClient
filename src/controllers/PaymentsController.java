package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Address;
import beans.Payment;
import services.AddressesFromServer;
import services.PaymentsFromServer;

/**
 * Servlet implementation class PaymentsController
 */

public class PaymentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		
		if(session==null || (session != null && session.getAttribute("user_id")== null))
		{	
			request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
	
		}
		
		int idcust =(int)session.getAttribute("user_id"); 
		
		try 
		{
			if (action.equals("showAll"))
			{	
				
				 List<Payment> listP = PaymentsFromServer.findAll(idcust);
				
				request.setAttribute("PaymentsList", listP);
				request.getRequestDispatcher("PaymentsView.jsp").forward(request,response);
				
			}
		}catch (Exception e) {
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
		
		if(session == null)
		{	
			request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
		}
		
		int idcust =(int)session.getAttribute("user_id"); 
		
		
		String type = request.getParameter("type");
		String pan  = request.getParameter("pan");
		String cvv = request.getParameter("cvv");
		int month = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));
		
		
		PaymentsFromServer.create(idcust, type, pan, cvv, month, year);
		
		List<Payment> listP =  new ArrayList<Payment>();
		PaymentsFromServer.findAll(idcust);
		
		request.setAttribute("PaymentsList", listP);
		request.getRequestDispatcher("PaymentsView.jsp").forward(request,response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
