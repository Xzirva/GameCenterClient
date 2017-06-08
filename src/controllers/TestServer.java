package controllers;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Address;
import beans.Customer;
import beans.Order;
import beans.Product;
import server_interfaces.ServerInterfaceByGet;
import services.CustomersFromServer;
import services.AddressesFromServer;
import services.LoginToServer;
import services.OrdersFromServer;
import services.ProductsFromServer;

@Path("test-server") 

public class TestServer {
	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Address test_server() throws Exception
	{ 
		//String s = ServerInterfaceByGet.test_post();
		//JSONObject json = (JSONObject) new JSONParser().parse(s);
		//JSONArray json = (JSONArray) new JSONParser().parse(s);
		//ObjectMapper mapper = new ObjectMapper();
		//Customer a = mapper.readValue(json.get(0).toString(), Customer.class);
//		String first_name = "firstdddnaddddddddmeze";
//		String last_name = "ladsdddtnamddddeddddsssss";
//		String gender = "M";
//		String email = "emaildddddddddddddddddd@mail.com";
//		String username = "usernaddddsssssssssdddddme12";
//		String password = "password";
//		return LoginToServer.register(gender, first_name, last_name, email, username, password);
		// String address, String zipcode, String city, String country, String type
		//return AddressesFromServer.create(35, "address","12457", "city", "country","shipping");
		//OrdersFromServer.addToCart(1, 3, 5);
		return AddressesFromServer.update(35, 123, "My fucking address", "66699", "The fucking city", "FREAER", "shipping");
		
		
	}	
}
