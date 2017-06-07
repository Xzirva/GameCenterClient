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

public class AdminProductsController extends HttpServlet {
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
		
		if(action!=null)
		{
			if(action.equals("show"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Product p = new Product();
				try 
				{
					 p = ProductsFromServer.findId(id);
				} catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				request.setAttribute("Product", p);
				
				
				// Forward to /WEB-INF/views/productListView.jsp
		        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/achatProduct.jsp");
		        dispatcher.forward(request, response);
				
				
			}
			if(action.equals("delete"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				 
					List<Product> listP = new ArrayList<Product>();
			       
			       try
			       {
			    	   listP = ProductsFromServer.findAll();
			       } catch (ParseException e) 
			       {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       }
					
					request.setAttribute("ProductsList", listP);
					
					
					// Forward to /WEB-INF/views/productListView.jsp
			        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/AdminProductsView.jsp");
			        dispatcher.forward(request, response);
			}
			if(action.equals("edit"))
			{
			
			}
		}
		else
		{
	       List<Product> listP = new ArrayList<Product>();
	       
	       try
	       {
	    	   listP = ProductsFromServer.findAll();
	       } catch (ParseException e) 
	       {
			// TODO Auto-generated catch block
			e.printStackTrace();
	       }
	      
			request.setAttribute("ProductsList", listP);
			
			
			// Forward to /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/AdminProductsView.jsp");
	        dispatcher.forward(request, response);
		}
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
		 response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 int id = Integer.parseInt(request.getParameter("id"));
		 
	       List<Product> listP = new ArrayList<Product>();
	       
	       try
	       {
	    	   listP = ProductsFromServer.findAll();
	       } catch (ParseException e) 
	       {
			// TODO Auto-generated catch block
			e.printStackTrace();
	       }
	      
			request.setAttribute("ProductsList", listP);
			
			
			// Forward to /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/AdminProductsView.jsp");
	        dispatcher.forward(request, response);
	
	}
		// TODO Auto-generated method stub

}
