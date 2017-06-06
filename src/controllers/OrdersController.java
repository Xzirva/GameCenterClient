package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import beans.OrderLine;
import beans.Order;
import beans.Customer;
import beans.Product;
import services.ProductsFromServer;
import services.OrdersFromServer;
//import dao.ProductsDao;

/**
 * Servlet implementation class OrderController
 */

public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action == null)
		{
			
			List<Product> listP = new ArrayList<Product>();
				       
			try
			{
				 listP = ProductsFromServer.findAll();
				 request.setAttribute("ProductsList", listP);
				request.getRequestDispatcher("achat.jsp").forward(request, response);
			
			} catch (ParseException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				      			
		}
		else
		{
						
			if(action.equals("show"))
			{
				  List<Product> listP = new ArrayList<Product>();
			       
			       try
			       {
			    	   listP = ProductsFromServer.findAll();
			    	   request.setAttribute("ProductsList", listP);		
						request.getRequestDispatcher("achat.jsp").forward(request, response);
			       } catch (ParseException e) 
			       {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       }
				
			}
			else if(action.equals("showProduct"))
			{
				try
				{
					int id = Integer.parseInt(request.getParameter("id"));
				    Product p = ProductsFromServer.findId(id);
				    request.setAttribute("Product", p);		
					request.getRequestDispatcher("achatProduct.jsp").forward(request, response);
			    }
				catch (ParseException e) 
			       {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       }
			}
			else if(action.equals("showCart"))
			{
				try 
				{
					//Object o  = request.getSession().getAttribute("Customer");
					//Customer cust = (Customer) o;
					
					
					Order cart = OrdersFromServer.findCart(3);
					request.setAttribute("Cart", cart);		
					request.getRequestDispatcher("cart.jsp").forward(request,response);
				} catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(action.equals("removeProduct"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Object o = request.getSession().getAttribute("panier");
				
				if(o!=null)
				{
//					Order panier = (Order)o;
//					if(panier.getLignes().size()>num){
//						panier.getLignes().remove(num);
//						request.getSession().setAttribute("panier",panier);
//						/** con l'ultima istruzione ripristiniamo 
//						 * il paniere nella sessione**/
				}
				request.getRequestDispatcher("panier.jsp").forward(request, response);
			}	
			else if(action.equals("removePanier"))
			{
		
				request.getSession().removeAttribute("panier");
				request.getRequestDispatcher("panier.jsp").forward(request, response);
			}
			else if(action.equals("paydelivery"))
			{
		
				request.getSession().removeAttribute("panier");
				request.getRequestDispatcher("paydelivery.jsp").forward(request, response);
			}
			else if(action.equals("paybilling"))
			{
		
				request.getSession().removeAttribute("panier");
				request.getRequestDispatcher("paybilling.jsp").forward(request, response);
			}
			else if(action.equals("paypayment"))
			{
		
				request.getSession().removeAttribute("panier");
				request.getRequestDispatcher("paypayment.jsp").forward(request, response);
			}
			
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//recuperer les parametres: idProduct, qte
				int idProduct = Integer.parseInt(request.getParameter("productid"));
				int qty = Integer.parseInt(request.getParameter("quantity"));
				
				try 
				{
					//Object o  = request.getSession().getAttribute("Customer");
					//Customer cust = (Customer) o;
					
					//Get the cart
					Order cart = OrdersFromServer.findCart(3);
				
					if(cart == null) 
					{
						cart = new Order();
						//insert new cart in the DB
					} 
				
					cart = OrdersFromServer.addToCart(3, idProduct, qty);
					
					request.setAttribute("Cart", cart);		
					request.getRequestDispatcher("cart.jsp").forward(request,response);
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
	}
}

//
//
//}
