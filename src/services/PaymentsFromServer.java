package services;

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

import beans.Customer;
import beans.Payment;
import server_interfaces.ServerInterfaceByGet;

public class PaymentsFromServer {
	private static ObjectMapper mapper = new ObjectMapper();
	public static List<Payment> findAll(int customer_id, String authToken) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id + "/payments");
		String s = ServerInterfaceByGet.get_request(url, authToken);
		JSONArray jsons = (JSONArray) new JSONParser().parse(s);
		List<Payment> lu = new ArrayList<Payment>();
		for (int i = 0; i < jsons.size(); i++) {
			  Payment current = serializePayment((JSONObject) jsons.get(i));
			  lu.add(current);
		}
		return lu;
		
	}
	
	public static Payment findId(int customer_id, int id, String authToken) throws ParseException, JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id + "/payments/" + id);
		String s = ServerInterfaceByGet.get_request(url, authToken);
		JSONObject jsons = (JSONObject) new JSONParser().parse(s);
		return serializePayment(jsons);
	}
	
	public static Payment update(int customer_id, int id, String type, String pan, String cvv, int month,int year, String authToken) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id + "/payments/" + id + "/update");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("type", type);
		params.put("pan", pan);
		params.put("cvv", cvv);
		params.put("month", month);
		params.put("year", year);
		String s = ServerInterfaceByGet.write_request(url, "PUT", authToken, params);
		JSONObject jsons = (JSONObject) new JSONParser().parse(s);
		return serializePayment(jsons);
	}
	
	public static Payment create(int customer_id, String type, String pan, String cvv, int month,int year, String authToken) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id + "/payments/create");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("type", type);
		params.put("pan", pan);
		params.put("cvv", cvv);
		params.put("month", month);
		params.put("year", year);
		
		String s = ServerInterfaceByGet.write_request(url, "POST", authToken, params);
		JSONObject jsons = (JSONObject) new JSONParser().parse(s);
		return serializePayment(jsons);
	}
	
	public static List<Payment> delete(int customer_id, int id, String authToken) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id + "/payments/" + id);
		String s = ServerInterfaceByGet.write_request(url, "DELETE", authToken);
		JSONArray jsons = (JSONArray) new JSONParser().parse(s);
		List<Payment> lu = new ArrayList<Payment>();
		for (int i = 0; i < jsons.size(); i++) {
			  Payment current = serializePayment((JSONObject) jsons.get(i));
			  lu.add(current);
		}
		return lu;
	}
	
	private static Payment serializePayment(JSONObject payment_json) throws ParseException, JsonParseException, JsonMappingException, IOException{
		Customer customer = mapper.readValue(payment_json.get("customer").toString(), Customer.class);
//		(int id, String address, String zip, String city, String country,
//				String type, boolean status, Customer cust)
		Payment payment = new Payment(Integer.parseInt(payment_json.get("id").toString()), payment_json.get("type").toString(), payment_json.get("pan").toString(), payment_json.get("cvv").toString(),
				Integer.parseInt(payment_json.get("month").toString()),Integer.parseInt(payment_json.get("year").toString()), customer);
		return payment;
	}
}
