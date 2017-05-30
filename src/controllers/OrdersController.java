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
			else if(action.equals("showPanier"))
			{
				//montre la liste dans une nouvelle page
				request.getRequestDispatcher("showPanier.jsp").forward(request,response);
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
				int idProduct = Integer.parseInt(request.getParameter("id"));
				int qty = Integer.parseInt(request.getParameter("quantity"));
				
				try 
				{
					//Get the Product
					Product p = ProductsFromServer.findId(idProduct);
			
					//Get the cart
					Order cart = null;//OrdersFromServer.findCart();
				
					if(cart == null) 
					{
						cart = new Order();
						//insert new cart in the DB
					}
					
					//Check if the product already there
					OrderLine ol = new OrderLine();
					//ol = OrdersFromServer.findProduct(cart.getId(), idProduct);
					
					if(ol == null)//add LineOrder to the cart
					{
						ol = new OrderLine();
						ol.setProd(p);
						ol.setQte(qty);
//						OrdersFromServer.addOrderLine(cart.getId(), lo);
					}
					else
					{
//						OrdersFromServer.setOrderLine(cart.getId(), ol.getId(), qty);
					}
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
							
				
				//int position=panier.getLignes().indexOf(lc);
				//indexOf mi restituisce la posizione dell'elemento lc nella lista panier
//				if(position==-1)
//					//se non ho ancora scelto quel prodotto lo aggiungo
//					panier.getLignes().add(lc);
//				else{
//					//se il prodotto esiste già nel paniere aggiorno la quantità
//					int newQty=lc.getQte() + panier.getLignes().get(position).getQte();
//					panier.getLignes().get(position).setQte(newQty);
				//}
				//request.getSession().setAttribute("panier", cart);
				
				List<Product> lp;
				try 
				{
					lp = ProductsFromServer.findAll();
					
					request.setAttribute("listeP", lp);
					request.getRequestDispatcher("achat.jsp").forward(request, response);
				} catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
}

//
//
//}
