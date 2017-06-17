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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		// TODO Auto-generated method stub
		//recuperer les parametres: idProduct, qte
		try {
				Enumeration<String> parameterNames = request.getParameterNames();
				String action = "login";
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = null;
				String gender = null;
				String first_name = null;
				String last_name = null;
				while (parameterNames.hasMoreElements() && action.equals("login")) {
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
				
				Order cart;
				cart = OrdersFromServer.findCart(user.getId(), authToken.getValue());
					
				request.setAttribute("cart", cart);
				request.getRequestDispatcher("cart.jsp").forward(request, response);
				
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
}
