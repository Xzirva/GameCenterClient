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
import services.ClientInterface;
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
	
		try {
			String action = request.getParameter("action");
			if(action== null || action.equals("myaccount"))
			{
				HttpSession session = request.getSession(false);
				if(session==null || (session != null && session.getAttribute("user_id")== null))
				{	
					request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
			
				}
				else
				{
					int custid = (int)session.getAttribute("user_id"); 
					System.out.println("ID Cust " + custid);
					Customer cust = CustomersFromServer.findId(custid, ClientInterface.findAuthToken(request));
					request.setAttribute("CustomersList", cust);
					request.getRequestDispatcher("CustomersView.jsp").forward(request, response);
				} 
			}
		} catch (Exception e) {
			System.out.println("------------------- YES: " + e.getMessage());
			System.out.println("------------------- YES: " + e.getMessage().equals("Unauthorized action: Please Check out authentication(401)"));
			if(e.getMessage().equals("Unauthorized action: Please Check out authentication(401)")){
				response.sendRedirect(request.getContextPath() + "/LoginFormCustomer.jsp");
			}	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lastname = request.getParameter("firstname");
		String firstname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		
		//CustomersFromServer.
		
	}

}
