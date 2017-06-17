package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;

import beans.Order;
import beans.Customer;
import beans.Product;
import beans.Address;
import beans.Payment;
import services.ProductsFromServer;
import services.AddressesFromServer;
import services.CustomersFromServer;
import services.OrdersFromServer;
import services.PaymentsFromServer;
import services.ClientInterface;

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
		
	
		try {
			if (action.equals("show"))
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
				       
			else if (action.equals("showProduct"))
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
			else if (action.equals("showCart"))
				{
					HttpSession session = request.getSession(false);
					
					if(session==null || (session != null && session.getAttribute("user_id")== null))
					{	
						request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
				
					}
					
					try 
					{
						int custid =(int)session.getAttribute("user_id"); 
						System.out.println("Customer id: " + custid);
						
						
						Order cart = OrdersFromServer.findCart(custid, ClientInterface.findAuthToken(request));
						request.setAttribute("Cart", cart);		
						request.getRequestDispatcher("cart.jsp").forward(request,response);
					} catch (ParseException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}	
			else if (action.equals("removeProduct"))
				{
					int productid = Integer.parseInt(request.getParameter("productid"));
					
					try 
					{
						HttpSession session = request.getSession(false);
						
						if(session == null)
						{	
							request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
					
						}
						
						int custid =(int)session.getAttribute("user_id"); 
						System.out.println("Customer id: " + custid);
							
						//Get the cart
						Order cart = OrdersFromServer.findCart(custid, ClientInterface.findAuthToken(request));
									
						cart = OrdersFromServer.removeOrderLine(3, productid, ClientInterface.findAuthToken(request));
						
						request.setAttribute("Cart", cart);		
						request.getRequestDispatcher("cart.jsp").forward(request,response);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
			else if (action.equals("removeCart"))
				{
					try 
					{
						HttpSession session = request.getSession(false);
						
						if(session == null)
						{	
							request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
					
						}
						
						int custid =(int)session.getAttribute("user_id"); 
						System.out.println("Customer id: " + custid);
						
						Order cart = OrdersFromServer.findCart(custid, ClientInterface.findAuthToken(request));
						if(cart!= null)
							cart = OrdersFromServer.clear(custid, ClientInterface.findAuthToken(request));
						
						request.setAttribute("Cart", cart);		
						request.getRequestDispatcher("cart.jsp").forward(request,response);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
				}
			
			else if (action.equals("showOrders"))
				{
					try 
					{
						HttpSession session = request.getSession(false);
						
						if(session == null)
						{	
							request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
					
						}
						
						int custid =(int)session.getAttribute("user_id"); 
						System.out.println("Customer id: " + custid);
						Customer cust = CustomersFromServer.findId(custid, ClientInterface.findAuthToken(request));
						
						List <Order> orders = OrdersFromServer.findAll(cust, ClientInterface.findAuthToken(request));
						System.out.println("******" + orders.size());
						
						request.setAttribute("ListOrders", orders);		
						request.getRequestDispatcher("OrdersView.jsp").forward(request,response);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
			else if(action.equals("showOrder"))
			{
				try 
				{
					HttpSession session = request.getSession(false);
					
					if(session==null || (session != null && session.getAttribute("user_id")== null))
					{	
						request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
				
					}
					
					int custid =(int)session.getAttribute("user_id"); 
					int orderid = Integer.parseInt(request.getParameter("id"));
					
					System.out.println("Customer id: " + custid);
					
					Order order = OrdersFromServer.findOrder(custid, orderid, ClientInterface.findAuthToken(request));
	
					
					request.setAttribute("Order", order);		
					request.getRequestDispatcher("OrdersView.jsp").forward(request,response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			else if(action.equals("pay"))
			{
				try 
				{
					HttpSession session = request.getSession(false);
					
					if(session==null || (session != null && session.getAttribute("user_id")== null))
					{	
						request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
				
					}
					
					int custid =(int)session.getAttribute("user_id"); 
					System.out.println("Customer id: " + custid);
				
					List<Address> Lshipping = AddressesFromServer.findAll(custid, "shipping", ClientInterface.findAuthToken(request));
					List<Address> Lbilling  = AddressesFromServer.findAll(custid, "billing", ClientInterface.findAuthToken(request));
					List<Payment> Lpayment = PaymentsFromServer.findAll(custid, ClientInterface.findAuthToken(request));
					
					if(Lshipping==null || Lbilling==null || Lpayment==null)
					{
						request.getRequestDispatcher("http://localhost:8080/GameCenterClient/customers?action=myaccount").forward(request,response);
					}
					request.setAttribute("AddressesShippingList", Lshipping);		
					request.setAttribute("AddressesBllingList", Lbilling);
					request.setAttribute("PaymentList", Lpayment);
					request.getRequestDispatcher("payForm.jsp").forward(request,response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			
			}
			else if(action.equals("console"))
			{
				try
				{
				String consolename = request.getParameter("name");
	
				if(consolename.equals("XBox"))
				{
					List<Product> listP = ProductsFromServer.filter("console", "xbox");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
				else if(consolename.equals("Wii"))
				{
					List<Product> listP = ProductsFromServer.filter("console", "wii");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
				else if(consolename.equals("WiiU"))
				{
					List<Product> listP = ProductsFromServer.filter("console", "wiiu");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
					
				}
				else if(consolename.equals("PSP"))
				{
					List<Product> listP = ProductsFromServer.filter("console", "psp");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
					
				}
				else if(consolename.equals("PlayStation"))
				{
					List<Product> listP = ProductsFromServer.filter("console", "playstation");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
					
				}
				else if(consolename.equals("GameCube"))
				{
					List<Product> listP = ProductsFromServer.filter("console", "game cube");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else if(action.equals("genre"))
			{
				try
				{
				String name = request.getParameter("name");
				if(name.equals("action"))
				{
					List<Product> listP = ProductsFromServer.filter("genre", "action");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
				else if(name.equals("adventure"))
				{
					List<Product> listP = ProductsFromServer.filter("genre", "adventure");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
				else if(name.equals("race"))
				{
					List<Product> listP = ProductsFromServer.filter("genre", "race");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
				else if(name.equals("dance"))
				{
					List<Product> listP = ProductsFromServer.filter("genre", "dancing");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
				else if(name.equals("educational"))
				{
					List<Product> listP = ProductsFromServer.filter("genre", "educational");
					
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String type = request.getParameter("type");
						
			try 
			{
				if(type.equals("addproduct"))
				{
					HttpSession session = request.getSession(false);
					
					if(session==null || (session != null && session.getAttribute("user_id")== null))
					{	
						request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
				
					}
				
					int custid =(int)session.getAttribute("user_id"); 
					
					int idProduct = Integer.parseInt(request.getParameter("productid"));
					int qty = Integer.parseInt(request.getParameter("quantity"));
				
				
					Order cart = OrdersFromServer.addToCart(custid, idProduct, qty, ClientInterface.findAuthToken(request));
					
 	    			request.setAttribute("Cart", cart);		
					request.getRequestDispatcher("cart.jsp").forward(request,response);
					
				}
				else if (type.equals("placeorder"))
				{
					HttpSession session = request.getSession(false);
					
					if(session==null || (session != null && session.getAttribute("user_id")== null))
					{	
						request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
				
					}
				
					int custid =(int)session.getAttribute("user_id"); 
					
					int idcust = Integer.parseInt(request.getParameter("customer"));
					int idpay = Integer.parseInt(request.getParameter("payment"));
					Order order = OrdersFromServer.payCart(idcust, idpay, ClientInterface.findAuthToken(request));
			
					request.setAttribute("Order", order);		
					request.getRequestDispatcher("OrdersView.jsp").forward(request,response);
				}
				else if(type.equals("search"))
				{
					String productname = request.getParameter("product");
					List<Product> listP = ProductsFromServer.filter("name", productname);
				
					request.setAttribute("ProductsList", listP);		
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				
				}
			} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
	}
				
			
}
//
//
//}
