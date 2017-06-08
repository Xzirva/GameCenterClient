package services;

import static java.lang.Math.toIntExact;

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

import beans.Product;
import server_interfaces.ServerInterfaceByGet;

public class ProductsFromServer {

	
	public static List<Product> findAll() throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/products");
		String s = ServerInterfaceByGet.get_request(url);
		JSONArray jsons = (JSONArray) new JSONParser().parse(s);
		List<Product> lu = new ArrayList<Product>();
		for (int i = 0; i < jsons.size(); i++) {
			  Product current = build_product((JSONObject) jsons.get(i));
			  lu.add(current);
		}
		return lu;
		
	}
	
	public static Product findId(int id) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/products/" + id);
		String s = ServerInterfaceByGet.get_request(url);
		JSONObject jsons = (JSONObject) new JSONParser().parse(s);
		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(jsons.toString(), Product.class);
		return build_product(jsons);
	
	}
	private static Product build_product(JSONObject jsons) {
		Product current = new Product(toIntExact( (long) jsons.get("id")), (String) jsons.get("name"), (String) jsons.get("genre"), (String) jsons.get("publisher"), toIntExact( (long) jsons.get("agemin")), (String) jsons.get("console"),
				(String) jsons.get("releasedate"), (double) jsons.get("price"), toIntExact( (long) jsons.get("quantity")), (String) jsons.get("description"));

		return current;
	}
}
