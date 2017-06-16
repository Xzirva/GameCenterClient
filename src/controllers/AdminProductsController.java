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

import org.json.simple.parser.ParseException;
import java.io.IOException;
import services.ProductsFromServer;
/**
 * Servlet implementation class ProductsController
 */

public class AdminProductsController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductsController() {
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
		
			if(action==null || action.equals("showAll"))
			{
				try 
				{
					List<Product> listP = ProductsFromServer.findAll();
					request.setAttribute("ProductsList", listP);
						
					// Forward to /WEB-INF/views/productListView.jsp
			        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProductsView.jsp");
			        dispatcher.forward(request, response);
					
				} 
				catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		String name        = request.getParameter("name");
		String maingenre   = request.getParameter("maingenre");
		String publisher   = request.getParameter("publisher");
		int agemin         = Integer.parseInt(request.getParameter("agemin"));
		String console     = request.getParameter("console");
		int year 	       = Integer.parseInt(request.getParameter("year"));
	    int month          = Integer.parseInt(request.getParameter("month"));
	    int day            = Integer.parseInt(request.getParameter("day"));
		double price       = Double.parseDouble(request.getParameter("price"));
		int quantity       = Integer.parseInt(request.getParameter("quantity"));
		String description = request.getParameter("description");
		
		ProductsFromServer.create(name, agemin, day, month, year, price, quantity, description, console, maingenre, publisher);
		
		List<Product> listP = ProductsFromServer.findAll();
		request.setAttribute("ProductsList", listP);
			
		// Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProductsView.jsp");
        dispatcher.forward(request, response);
        
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

}
