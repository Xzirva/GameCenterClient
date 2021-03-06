package services;

//import java.io.IOException;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Customer;
import server_interfaces.ServerInterfaceByGet;
import static java.lang.Math.toIntExact;

public class LoginToServer {

	public static Customer login(String username, String password) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/auth/login");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("username", username);
		params.put("pwd", password);
	  	String response = ServerInterfaceByGet.write_request(url, "POST",null, params);
	  	JSONObject json = (JSONObject) new JSONParser().parse(response);
		JSONObject user_json = (JSONObject) json.get("user");
		Customer loggedIn = new Customer(toIntExact( (long) user_json.get("id")), 
				(String) user_json.get("firstname"), (String)  user_json.get("lastname"), 
				(String) user_json.get("gender"), (String) user_json.get("email"), (String) user_json.get("username"), 
				(String) user_json.get("pwd"), (boolean) user_json.get("admin"), (String) json.get("authentication_token"));
		return loggedIn;
		
	}
	
	public static Customer register(String gender, String first_name, String last_name, String email, String username, String password) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/auth/register");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("username", username);
		params.put("pwd", password);
		params.put("first_name", first_name);
		params.put("last_name", last_name);
		params.put("email", email);
		params.put("gender", gender);
	  	String response = ServerInterfaceByGet.write_request(url, "POST",null, params);
	  	JSONObject json = (JSONObject) new JSONParser().parse(response);
		JSONObject user_json = (JSONObject) json.get("user");
		System.out.print(json.keySet().toString());
		//toIntExact( (long) user_json.get("id"))
		Customer loggedIn = new Customer(Integer.parseInt(user_json.get("id").toString()), 
				(String) user_json.get("firstname"), (String)  user_json.get("lastname"), 
				(String) user_json.get("gender"), (String) user_json.get("email"), (String) user_json.get("username"), 
				(String) user_json.get("pwd"), (boolean) user_json.get("admin"), (String) json.get("authentication_token"));
		return loggedIn;
	}
}
