package services;

import java.util.LinkedHashMap;
import java.util.Map;

public class AuthenticationTokenManager {
	private static Map<String,Object> tokens = new LinkedHashMap<>();
	
	public static void addToken(String username, String token){
		tokens.put(username, token);
	}
}
