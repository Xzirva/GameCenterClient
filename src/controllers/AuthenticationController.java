package controllers;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;

import beans.Customer;
import beans.Order;
import beans.OrderLine;
import beans.Product;
import services.LoginToServer;
import services.OrdersFromServer;
import services.ProductsFromServer;

public class AuthenticationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		
		if(session==null || (session != null && session.getAttribute("user_id")== null))
		{	
			request.getRequestDispatcher("LoginFormCustomer.jsp").forward(request,response);
	
		}
		
		Cookie[] mycookies = request.getCookies();
		
//		for (int index=0; index< mycookies.length; index++)
//		{
//			if(mycookies[index].getName().equals("authentication_token"))
//			{
//				Cookie newcook = new Cookie("authentication_token", "TRY AGAIN!");
//				mycookies[index].setValue("YOU WISH!");	
//				response.addCookie(newcook);
//				System.out.println("Hello I am here");
//			}
//		}
		
		for (Cookie c : mycookies) {
			if(c.getName().equals("authentication_token")) {
				c.setValue("TRY AGAIN");
				response.addCookie(c);
				break;
			}
		}
		
		if (session != null) 
		{
		    session.invalidate();
		}
		
		request.getRequestDispatcher("index.html").forward(request,response);
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		//recuperer les parametres: idProduct, qte
				Enumeration<String> parameterNames = request.getParameterNames();
				String action = "login";
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = null;
				String gender = null;
				String first_name = null;
				String last_name = null;
				while (parameterNames.hasMoreElements() && action.equals("login")) 
				{
					String current = parameterNames.nextElement();
					System.out.println(current.toString());
					if(current.equals("register-user")) {
						action = "register";
						email = request.getParameter("email");
						gender = request.getParameter("gender");
						first_name = request.getParameter("firstname");
						last_name = request.getParameter("lastname");
					}
				}

				Customer user = null;
				
				try 
				{
					//Get the Product
					if(action == "register") {
						user = LoginToServer.register(gender, first_name, last_name, email, username, password);
						
					} else {
						user = LoginToServer.login(username, password);
					}
					
					HttpSession session = request.getSession();
					session.setAttribute("user_id", user.getId());
					
					user = LoginToServer.login(username, password);
					Cookie authToken = new Cookie("authentication_token", user.getAuthToken());
					response.addCookie(authToken);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				Order cart;
				try 
				{
					//request.getRequestDispatcher("http://localhost:8080/GameCenterClient/customers?action=myaccount").forward(request, response);
					cart = OrdersFromServer.findCart(user.getId());
					request.setAttribute("cart", cart);
					request.getRequestDispatcher("cart.jsp").forward(request, response);
				} catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
}