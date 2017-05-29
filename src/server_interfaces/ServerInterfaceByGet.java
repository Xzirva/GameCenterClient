package server_interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServerInterfaceByGet {

	public static String test() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/GameCenter/admins/web-services/customers");
		return get_request(url);
	}
	
	private static String get_request(URL url) {

		  try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			output = br.readLine();

			conn.disconnect();
			return output;
			

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		return null;

		}
	
	public static String test_post() {

		  try {
			  	URL url = new URL("http://localhost:8080/GameCenter/web-services/auth/login");
			  	Map<String,Object> params = new LinkedHashMap<>();
				params.put("username", "xxxxxx");
				params.put("password", "xxxxxx");
			  	return post_request(url, params);
			  } 
		  catch (MalformedURLException e) {

			  e.printStackTrace();
		  }
		  
		  catch (IOException e) {
			  e.printStackTrace();
		  }
		  return null;
	}
	public static String post_request(URL url, Map<String,Object> params) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		byte[] postDataBytes = post_params(params);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        BufferedReader br = new BufferedReader(new InputStreamReader(
    			(conn.getInputStream())));
        String output;
		System.out.println("Output from Server .... \n");
		output = br.readLine();
		System.out.println(output);
		conn.disconnect();
		return output;
	}
	public static byte[] post_params(Map<String,Object> params) throws UnsupportedEncodingException{
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String,Object> param : params.entrySet()) {
		    if (postData.length() != 0) postData.append('&');
		    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
		    postData.append('=');
		    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}
		return postData.toString().getBytes("UTF-8");
	}

}