package services;

import java.io.IOException;

import java.net.MalformedURLException;
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

import beans.Customer;
import beans.Order;
import beans.OrderLine;
import beans.Product;
import server_interfaces.ServerInterfaceByGet;
import services.ProductsFromServer;

public class OrdersFromServer {
	private static ObjectMapper mapper = new ObjectMapper();
	public static List<Order> findAll(Customer customer, String authToken) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer.getId() + "/orders");
		String s = ServerInterfaceByGet.get_request(url, authToken);
		JSONArray jsons = (JSONArray) new JSONParser().parse(s);
		
		List<Order> lu = new ArrayList<Order>();
		for (int i = 0; i < jsons.size(); i++) {
			JSONObject order_json = (JSONObject) jsons.get(i);
			Order current = serializeOrder(order_json);
			lu.add(current);
		}
		return lu;
		
	}
	
	public static Order findCart(int customer_id, String authToken) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/current_cart/cart");
		String s = ServerInterfaceByGet.get_request(url, authToken);
		JSONObject order_json = (JSONObject) new JSONParser().parse(s);
		System.out.println(order_json.keySet());

		return serializeOrder(order_json);
	}
	
	public static Order findOrder(int customer_id, int id, String authToken) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id +"/orders/" + id);
		String s = ServerInterfaceByGet.get_request(url, authToken);
		JSONObject order_json = (JSONObject) new JSONParser().parse(s);
		System.out.println(order_json.keySet());

		return serializeOrder(order_json);
	}
	
	public static Order addToCart(int customer_id, int product_id, int quantity, String authToken) throws Exception{
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/current_cart/add_to_cart");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("product_id", product_id);
		params.put("quantity", quantity);
		String s = ServerInterfaceByGet.write_request(url, "POST", authToken, params);
		JSONObject order_json = (JSONObject) new JSONParser().parse(s);
		return serializeOrder(order_json);
	}
	
	public static Order setOrderLine(int customer_id, int product_id, int quantity, String authToken) throws Exception{
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/current_cart/set_orderline");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("product_id", product_id);
		params.put("quantity", quantity);
		String s = ServerInterfaceByGet.write_request(url, "POST", authToken, params);
		JSONObject order_json = (JSONObject) new JSONParser().parse(s);
		return serializeOrder(order_json);
	}
	
	public static Order removeOrderLine(int customer_id, int product_id, String authToken) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/current_cart/remove?product_id=" + product_id);
		String s = ServerInterfaceByGet.write_request(url, "DELETE", authToken);
		JSONObject order_json = (JSONObject) new JSONParser().parse(s);
		return serializeOrder(order_json);
	}
	
	public static Order clear(int customer_id, String authToken) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/current_cart/clear");
		String s = ServerInterfaceByGet.write_request(url, "DELETE", authToken);
		JSONObject order_json = (JSONObject) new JSONParser().parse(s);
		return serializeOrder(order_json);
	}
	
	public static Order payCart(int customer_id, int payment_id, String authToken) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/orders/pay");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("payment_id", payment_id);
		String s = ServerInterfaceByGet.write_request(url, "POST", authToken, params);
		JSONObject order_json = (JSONObject) new JSONParser().parse(s);
		return serializeOrder(order_json);
	}
	
	private static List<OrderLine> serialiseOrderLines(JSONObject OrderJson) throws JsonParseException, JsonMappingException, IOException{
		JSONArray orderlines_json = (JSONArray) OrderJson.get("orderLines");
		List<OrderLine> lu = new ArrayList<OrderLine>();

		for (int i = 0; i < orderlines_json.size(); i++) {
			JSONObject order_line_json = (JSONObject) orderlines_json.get(i);
			Product prod = ProductsFromServer.build_product((JSONObject) order_line_json.get("prod"));
			OrderLine current = new OrderLine(Integer.parseInt(order_line_json.get("id").toString()), prod, Integer.parseInt(order_line_json.get("qte").toString()), (double) order_line_json.get("total"));
			lu.add(current);
		}
		return lu;
	}
	
	private static Order serializeOrder(JSONObject order_json) throws ParseException, JsonParseException, JsonMappingException, IOException{
		Customer customer = mapper.readValue(order_json.get("customer").toString(), Customer.class);
		Order current = new Order(Integer.parseInt(order_json.get("id").toString()), customer, order_json.get("paid") == "true", Double.parseDouble(order_json.get("total").toString()));
		List<OrderLine> list = serialiseOrderLines(order_json);
		current.setOrderLines(list);
		return current;
	}
	
	
	
}
