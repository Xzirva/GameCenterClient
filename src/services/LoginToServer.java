package services;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Customer;
import server_interfaces.ServerInterfaceByGet;

public class LoginToServer {

	public static Customer login(String username, String password) throws JsonParseException, JsonMappingException, IOException, ParseException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/auth/login");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("username", username);
		params.put("pwd", password);
	  	String response = ServerInterfaceByGet.post_request(url, params);
	  	JSONObject jsons = (JSONObject) new JSONParser().parse(response);
		ObjectMapper mapper = new ObjectMapper();
		Customer current = mapper.readValue(jsons.get("user").toString(), Customer.class);
		AuthenticationTokenManager.addToken(current.getUsername(), (String) jsons.get("authentication_token"));	
		return current;
		
	}
}
