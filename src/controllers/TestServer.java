package controllers;

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.JSONString;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import server_interfaces.ServerInterfaceByGet;

@Path("test-server") 

public class TestServer {
	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public JSONArray test_server() throws JSONException, ParseException
	{ 
		String s = ServerInterfaceByGet.test();
		JSONArray json = (JSONArray) new JSONParser().parse(s);
		//return new JSONArray("[\"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\", \"Thursday\", \"Friday\", \"Saturday\"]");
		//return new JSONObject(s);
		return json;
	} 
	
}
