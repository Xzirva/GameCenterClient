package controllers;
import beans.ConsoleType;
import beans.Product;
import beans.Publisher;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProductsController
 */
@WebServlet("/ProductsController")
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsController() {
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
		
	       List<Product> listP = new ArrayList<Product>();
	       //public Customer(int id, String fname, String lname, String gender, String email,
	       //String username) 
	         Publisher pub = new Publisher(1, "ubisoft");
	         ConsoleType cons = new ConsoleType(1, "Wii");
			 Product p = new Product(1, "test1", "action", pub, 18, cons, "2016-03-02", (float)34.99, 5, "here is a descr");
			 Product p2 = new Product(2, "test2", "action", pub, 18, cons, "2016-03-02", (float)34.99, 5, "here is a descr");
			
			 listP.add(p);
			listP.add(p2);
			
			request.setAttribute("ProductsList", listP);
			
			
			// Forward to /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/mainpage.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name        = request.getParameter("name");
		String maingenre   = request.getParameter("maingenre");
		int publisher      = Integer.parseInt(request.getParameter("publisher"));
		int agemin         = Integer.parseInt(request.getParameter("agemin"));
		int console        = Integer.parseInt(request.getParameter("console"));
		String releasedate = request.getParameter("releasedate");
		float price        = Float.parseFloat(request.getParameter("price"));
		int quantity       = Integer.parseInt(request.getParameter("quantity"));
		
		// TODO Auto-generated method stub
				//doGet(request, response);
				
		response.setContentType("text/html; charset=UTF-8");
		// Allocate a output writer to write the response message into the network socket
			   
					
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
	
	}
		// TODO Auto-generated method stub

}
