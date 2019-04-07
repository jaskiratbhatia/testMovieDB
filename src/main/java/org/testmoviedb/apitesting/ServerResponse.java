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
	

	 /**
	 * TODO: save the response in a file in format MovieId,ExpectedResponse
	 * Wrtie this method which will read this file or upload in memory and compare the result.
	 * @param movieId
	 * @param responseRecieved
	 * @return
	 */
	public boolean validateResponse(Integer movieId,String responseRecieved) {
		return true;
	}
}
