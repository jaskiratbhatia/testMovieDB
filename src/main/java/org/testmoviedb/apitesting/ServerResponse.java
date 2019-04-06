package org.testmoviedb.apitesting;

/**
 * Author @jaskiratbhatia
 * Date Apr/6/2019
 */

public class ServerResponse {
	
	private int statusCode;
	private String jsonResponse;
	
	public ServerResponse(int statusCode, String jsonResponse) {
		this.jsonResponse = jsonResponse;
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getJsonResponse() {
		return jsonResponse;
	}

	public String toString() {
		return "Status code returned " + statusCode +
				" Response JSON " + jsonResponse;
	}
}
