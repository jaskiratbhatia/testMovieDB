package org.testmoviedb.apitesting.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

/**
 * Author @jaskiratbhatia
 * Date Apr/6/2019
 */

public class ConfigProperties {
	private InputStream inputStream;
	private Properties prop = new Properties();
	private static ConfigProperties single_instance = null;
	
	public static ConfigProperties getInstance() throws IOException 
    { 
        if (single_instance == null) 
            single_instance = new ConfigProperties(); 
  
        return single_instance; 
    }
	
	private ConfigProperties() throws IOException {
		try {
			String propFileName = "/config.properties";
			inputStream = getClass().getResourceAsStream(propFileName);
			if (inputStream != null) {
				this.prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" 
						+ propFileName + "' not found in the classpath");
			}
  
			// get the property value and print it out
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	
	public Properties getProperties() {
		return prop;
	}

}
