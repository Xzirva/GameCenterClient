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
import beans.Address;
import server_interfaces.ServerInterfaceByGet;

public class AddressesFromServer 
{
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static List<Address> findAll(int customer_id, String type) throws JsonParseException, JsonMappingException, ParseException, IOException {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id + "/addresses/" + type);
		String s = ServerInterfaceByGet.get_request(url);
		JSONArray jsons = (JSONArray) new JSONParser().parse(s);
		List<Address> lu = new ArrayList<Address>();
		for (int i = 0; i < jsons.size(); i++) {
			JSONObject address_json = (JSONObject) jsons.get(i);
			  Address current = serializeAddress(address_json);
			  lu.add(current);
		}
		return lu;
	}
	
	private static Address serializeAddress(JSONObject address_json) throws ParseException, JsonParseException, JsonMappingException, IOException{
		Customer customer = mapper.readValue(address_json.get("customer").toString(), Customer.class);
//		(int id, String address, String zip, String city, String country,
//				String type, boolean status, Customer cust)
		Address current = new Address(Integer.parseInt(address_json.get("id").toString()), address_json.get("address").toString(), address_json.get("zipcode").toString(), address_json.get("city").toString(), 
				address_json.get("country").toString(), address_json.get("type").toString(), true, customer);
		return current;
	}
	
	public static Address create(int customer_id, String address, String zipcode, String city, String country, String type) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/addresses/create");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("address", address);
		params.put("zipcode", zipcode);
		params.put("city", city);
		params.put("country", country);
		params.put("type", type);
		String s = ServerInterfaceByGet.write_request(url, "POST", params);
		JSONObject address_json = (JSONObject) new JSONParser().parse(s);
		System.out.println(address_json.keySet());

		return serializeAddress(address_json);
	}
	
	public static Address update(int customer_id, int address_id,String address, String zipcode, String city, String country, String type) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/addresses/" + address_id + "/update");
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("address", address);
		params.put("zipcode", zipcode);
		params.put("city", city);
		params.put("country", country);
		params.put("type", type);
		String s = ServerInterfaceByGet.write_request(url, "PUT", params);
		JSONObject address_json = (JSONObject) new JSONParser().parse(s);
		System.out.println(address_json.keySet());

		return serializeAddress(address_json);
	}
	
	public static boolean delete(int customer_id, int address_id) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/addresses/" + address_id);
		String s = ServerInterfaceByGet.write_request(url, "DELETE");
		JSONObject address_json = (JSONObject) new JSONParser().parse(s);
		return (boolean) address_json.get("deleted");
	}
	
	public static Address find(int customer_id, int address_id) throws Exception {
		URL url = new URL("http://localhost:8080/GameCenter/web-services/customers/" + customer_id  + "/addresses/" + address_id);
		String s = ServerInterfaceByGet.get_request(url);
		JSONObject address_json = (JSONObject) new JSONParser().parse(s);
		return serializeAddress(address_json);
	}
	
}
