package org.testmoviedb.apitesting;

import java.io.IOException;
import java.util.Properties;

import org.testmoviedb.apitesting.utils.ConfigProperties;
import org.testmoviedb.apitesting.utils.HttpUtil;

/**
 * Author @jaskiratbhatia
 * Date Apr/6/2019
 */

public class APIBaseClass {
	
	public static HttpUtil httpClient = new HttpUtil();
	public static String Server_URL = null;
	public static String API_KEY = null;

	public APIBaseClass() {
		ConfigProperties prop;
		try {
			prop = ConfigProperties.getInstance();
		
		//TODO: fix it. This can throw NPE.
		Properties p = prop.getProperties();
		System.out.println("jas");
		if(Server_URL == null) {
			Server_URL = p.getProperty("url");
		}
		if(API_KEY == null) {
			API_KEY = p.getProperty("apikey");
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
