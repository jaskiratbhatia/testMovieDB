package org.testmoviedb.apitesting.api.movie;

import org.testmoviedb.apitesting.APIBaseClass;
import org.testmoviedb.apitesting.ServerResponse;

/**
 * Author @jaskiratbhatia
 * Date Apr/6/2019
 */

public class MovieAPI extends APIBaseClass {
	public static String movieAPIName = "movie/";
	
	private enum MovieMethods {
		CREDIT, DETAILS, ALTERNATE_TITLES, ACCOUNT_STATE,
		KEYWORDS, REVIEWS, LATEST;
				
		public String getAPIName() {
			switch(this) {
			case CREDIT: 
				return "/credits?";
			case DETAILS: 
				return null;
			case ACCOUNT_STATE: 
				return "/account_states?";
			case ALTERNATE_TITLES:
				return "/alternative_titles?";
			default: 
				return null;
			}
		}
	}
	
	/**
	 * This API requires movieId and API Key.
	 * Use this method, if you want to use default API KEY
	 * @param movieId
	 * @return
	 */
	public ServerResponse getCreditFor(String movieId) {
		String URL = buildUrl(movieId, API_KEY, MovieMethods.CREDIT).toString();
		
		ServerResponse response = httpClient.getHttpResponse(URL);
		
		return response;
	}
	
	/**
	 * This API requires movieId and API Key.
	 * Use this method, if you don't want to use default API KEY
	 * @param movieId
	 * @param apiKey
	 * @return
	 */
	public ServerResponse getCreditFor(String movieId, String apiKey) {
		String URL = buildUrl(movieId, apiKey, MovieMethods.CREDIT).toString();
				
		ServerResponse response = httpClient.getHttpResponse(URL);
		
		return response;
	}
	
	//TO BE IMPLEMENTED
	public ServerResponse getDetails(Integer movieId) {
		return null;
	}
	
	public ServerResponse getAlternativeTitles(String movieId, String country) {
		String URL = buildUrl(movieId, API_KEY, MovieMethods.ALTERNATE_TITLES).toString();
		//TODO: fix this in url builder
		URL+="&country="+country;

		ServerResponse response = httpClient.getHttpResponse(URL);
		return response;
	}
		
	private static String apikeyText = "api_key=";
	
	public StringBuilder buildUrl(String movieId, String apiKey, MovieMethods methodName) {
		StringBuilder str = new StringBuilder(Server_URL);
		str.append(movieAPIName);
		str.append(movieId);
		str.append(methodName.getAPIName());
		str.append(apikeyText + apiKey);
		return str;
	}

}

