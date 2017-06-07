package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;

import beans.Customer;
import services.CustomersFromServer;

/**
 * Servlet implementation class CustomersController
 */
@WebServlet("/CustomersController")
public class CustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		String action = request.getParameter("action");
		if(action == null || action=="myaccount")
		{
			if(session == null)
			{
				request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
		
			}
			else
			{
				int custid = (int)session.getAttribute("user_id"); 
				System.out.println("ID Cust " + custid);
				try 
				{
					Customer cust = CustomersFromServer.findId(custid);
					request.setAttribute("CustomersList", cust);
					request.getRequestDispatcher("CustomersView.jsp").forward(request, response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
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
