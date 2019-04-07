package org.testmoviedb.apitesting.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.testmoviedb.apitesting.ServerResponse;

/**
 * Author @jaskiratbhatia
 * Date Apr/6/2019
 */

public class HttpUtil {
	
	//TODO: use a variable for httpConnection instead
	//private HttpURLConnection conn;
	//Not using this yet, but I could have created multiple helpers for getHttResponse method
	@SuppressWarnings("unused")
	private void setConnection(URL url) {
		try{
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setReadTimeout(1000);
			conn.setConnectTimeout(10000);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ServerResponse getHttpResponse(String urlString) throws RuntimeException{
		String result = "";
		ServerResponse response = null;
		try{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			InputStream in;
			if (conn.getResponseCode() >= 500) {
				throw new RuntimeException("Something wrong with the URL or Server not reachable "
						+ conn.getResponseCode());
			}
			if (conn.getResponseCode() != 200) {
				in = conn.getErrorStream();
			}
			else {
				in = conn.getInputStream();
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(in)));
			String output = null;
			while ((output = br.readLine()) != null) {
				result+=output;
			}
			response = new ServerResponse(conn.getResponseCode(), result);
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;

	}

}
