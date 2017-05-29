package controllers;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Customer;
import beans.Product;
import server_interfaces.ServerInterfaceByGet;
import services.ProductsFromServer;

@Path("test-server") 

public class TestServer {
	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Product> test_server() throws JSONException, ParseException, JsonParseException, JsonMappingException, IOException
	{ 
		String s = ServerInterfaceByGet.test_post();
		JSONObject json = (JSONObject) new JSONParser().parse(s);
		
		//JSONArray json = (JSONArray) new JSONParser().parse(s);
		//ObjectMapper mapper = new ObjectMapper();
		//Customer a = mapper.readValue(json.get(0).toString(), Customer.class);
		return ProductsFromServer.findAll();
	} 
	
}
