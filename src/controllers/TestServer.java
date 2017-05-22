package controllers;

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server_interfaces.ServerInterfaceByGet;

@Path("test-server") 

public class TestServer {
	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public JSONArray test_server() throws JSONException
	{ 
		ServerInterfaceByGet itf = new ServerInterfaceByGet();
		String s = itf.test();
		return new JSONArray();
	} 
	
}
