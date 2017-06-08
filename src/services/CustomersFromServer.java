package services;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Customer;
import server_interfaces.ServerInterfaceByGet;

public class CustomersFromServer {

	public static List<Customer> findAll() throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers");
		String s = ServerInterfaceByGet.get_request(url);
		JSONArray jsons = (JSONArray) new JSONParser().parse(s);
		ObjectMapper mapper = new ObjectMapper();
		List<Customer> lu = new ArrayList<Customer>();
		for (int i = 0; i < jsons.size(); i++) {
			  Customer current = mapper.readValue(jsons.get(i).toString(), Customer.class);
			  lu.add(current);
		}
		return lu;
		
	}
	
	public static Customer findId(int id) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + id);
		String s = ServerInterfaceByGet.get_request(url);
		JSONObject jsons = (JSONObject) new JSONParser().parse(s);
		ObjectMapper mapper = new ObjectMapper();
		Customer current = mapper.readValue(jsons.toString(), Customer.class);
		return current;
	}
}