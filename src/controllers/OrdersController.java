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

import org.json.simple.parser.ParseException;

import beans.OrderLine;
import beans.Order;
import beans.Customer;
import beans.Product;
import services.ProductsFromServer;
import services.CustomersFromServer;
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
		
		switch(action)
		{
			case "show":
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
			       break;
			}
			       
			case "showProduct":
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
				break;
			}
			case "showCart":
			{
				HttpSession session = request.getSession(false);
				try 
				{
					int custid =(int)session.getAttribute("user_id"); 
					System.out.println("Customer id: " + custid);
					
					
					Order cart = OrdersFromServer.findCart(custid);
					request.setAttribute("Cart", cart);		
					request.getRequestDispatcher("cart.jsp").forward(request,response);
				} catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}	
			case "removeProduct":
			{
				int productid = Integer.parseInt(request.getParameter("productid"));
				
				try 
				{
					HttpSession session = request.getSession(false);
					
					int custid =(int)session.getAttribute("user_id"); 
					System.out.println("Customer id: " + custid);
						
					//Get the cart
					Order cart = OrdersFromServer.findCart(custid);
								
					cart = OrdersFromServer.removeOrderLine(3, productid);
					
					request.setAttribute("Cart", cart);		
					request.getRequestDispatcher("cart.jsp").forward(request,response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			case "removeCart":
			{
				try 
				{
					HttpSession session = request.getSession(false);
					
					int custid =(int)session.getAttribute("user_id"); 
					System.out.println("Customer id: " + custid);
					
					Order cart = OrdersFromServer.findCart(custid);
					if(cart!= null)
						cart = OrdersFromServer.clear(custid);
					
					request.setAttribute("Cart", cart);		
					request.getRequestDispatcher("cart.jsp").forward(request,response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			case "showOrders":
			{
				try 
				{
					HttpSession session = request.getSession(false);
					
					int custid =(int)session.getAttribute("user_id"); 
					System.out.println("Customer id: " + custid);
					Customer cust = CustomersFromServer.findId(custid);
					
					List <Order> orders = OrdersFromServer.findAll(cust);
					
					
					request.setAttribute("ListOrders", orders);		
					request.getRequestDispatcher("OrdersView.jsp").forward(request,response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			default:
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
	
		
//			else if(action.equals("paydelivery"))
//			{
//		
//				request.getSession().removeAttribute("panier");
//				request.getRequestDispatcher("paydelivery.jsp").forward(request, response);
//			}
//			else if(action.equals("paybilling"))
//			{
//		
//				request.getSession().removeAttribute("panier");
//				request.getRequestDispatcher("paybilling.jsp").forward(request, response);
//			}
//			else if(action.equals("paypayment"))
//			{
//		
//				request.getSession().removeAttribute("panier");
//				request.getRequestDispatcher("paypayment.jsp").forward(request, response);
//			}
			
		
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
					HttpSession session = request.getSession(false);
					
					
					int custid =(int)session.getAttribute("user_id"); 
					System.out.println("Customer id: " + custid);
						
					//Get the cart
					Order cart = OrdersFromServer.findCart(custid);
				
					
					cart = OrdersFromServer.addToCart(3, idProduct, qty);
					
							
				
 	    			request.setAttribute("Cart", cart);		
					request.getRequestDispatcher("cart.jsp").forward(request,response);
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
	}
}

//
//
//}
