package services;

import static java.lang.Math.toIntExact;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	public static List<Product> create(String name, int agemin, int day, int month, int year, double price, int quantity, String description, String console_name, String genre, String publisher) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/admins/products/create");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("name", name);
		params.put("agemin", agemin);
		params.put("day", day);
		params.put("month", month);
		params.put("year", year);
		params.put("price", price);
		params.put("quantity", quantity);
		params.put("description", description);
		params.put("console", console_name);
		params.put("genre", genre);
		params.put("publisher", publisher);
		
		String s = ServerInterfaceByGet.write_request(url, "POST", params);
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
	public static Product build_product(JSONObject jsons) {
		Product current = new Product(toIntExact( (long) jsons.get("id")), (String) jsons.get("name"), (String) jsons.get("maingenre"), (String) jsons.get("publisher"), toIntExact( (long) jsons.get("agemin")), (String) jsons.get("console"),
				(String) jsons.get("releasedate"), (double) jsons.get("price"), toIntExact( (long) jsons.get("quantity")), (String) jsons.get("description"));
		return current;
	}
	
	public static List<Product> filter(String feature, String value) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/products/filter?feature="+ feature +"&value=" + value);
		String s = ServerInterfaceByGet.get_request(url);
		JSONArray jsons = (JSONArray) new JSONParser().parse(s);
		List<Product> lu = new ArrayList<Product>();
		for (int i = 0; i < jsons.size(); i++) {
			  Product current = build_product((JSONObject) jsons.get(i));
			  lu.add(current);
		}
		return lu;
	}
}
