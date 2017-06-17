package services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ClientInterface {
	public static String findAuthToken(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("authentication_token")) {
				return c.getValue();
			}
		}
		return null;
		
	}
}
