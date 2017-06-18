package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import beans.Customer;
import beans.Order;
import services.ClientInterface;
import services.CustomersFromServer;
import services.OrdersFromServer;

/**
 * Servlet implementation class CustomersController
 */

public class AdminCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCustomersController() {
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
		try {
			if(action.equals("show"))
			{
				List<Customer> listC = new ArrayList<Customer>();
				try 
				{
					
					listC = CustomersFromServer.findAll(ClientInterface.findAuthToken(request));
					request.setAttribute("CustomersList", listC);
					
			        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/AdminCustomersView.jsp");
			        dispatcher.forward(request, response);
				} catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			else if(action.equals("showOrders"))
			{
				try {
				int custid = Integer.parseInt(request.getParameter("id"));
				Customer cust;
				
				cust = CustomersFromServer.findId(custid, ClientInterface.findAuthToken(request));
					
				List <Order> orders = OrdersFromServer.findAll(cust, ClientInterface.findAuthToken(request));
						
				request.setAttribute("ListOrders", orders);		
				request.getRequestDispatcher("AdminOrdersView.jsp").forward(request,response);
				} 
				catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("------------------- YES: " + e.getMessage());
			System.out.println("------------------- YES: " + e.getMessage().equals("Unauthorized action: Please Check out authentication(401)"));
			if(e.getMessage().equals("Unauthorized action: Please Check out authentication(401)")){
				response.sendRedirect(request.getContextPath() + "/LoginFormCustomer.jsp");
			} else {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
				
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		   String id = (String) request.getParameter("id");
		 
		   // CustomersDao.delete(id);
		 
		   doGet(request, response);
	}
	
	

	   private static String htmlFilter(String message) 
	   {
	      if (message == null) return null;
	      int len = message.length();
	      StringBuffer result = new StringBuffer(len + 20);
	      char aChar;
	 
	      for (int i = 0; i < len; ++i) {
	         aChar = message.charAt(i);
	         switch (aChar) {
	             case '<': result.append("&lt;"); break;
	             case '>': result.append("&gt;"); break;
	             case '&': result.append("&amp;"); break;
	             case '"': result.append("&quot;"); break;
	             default: result.append(aChar);
	         }
	      }
	      return (result.toString());
	   }

}
