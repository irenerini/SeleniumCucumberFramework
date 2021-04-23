package com.wallethub.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*This file reads test data from the config.properties file*/

public class ConfigFileReader {
	private static Properties properties;
	private static String propertyFilePath = "configurations/config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("properties file not found" + propertyFilePath);
		}
	}

	public String getWHubUsername() {
		String username = properties.getProperty("WalletHubUsername");
		if (username != null)
			return username;
		else
			throw new RuntimeException("WalletHub username is not specified in the config file");
	}
	
	public String getWHubPassword() {
		String password = properties.getProperty("WalletHubPassword");
		if (password != null)
			return password;
		else
			throw new RuntimeException("WalletHub password is not specified in the config file");
	}
	
	public String getWHubReviewText() {
		String reviewtext = properties.getProperty("WalletHubReviewText");
		if (reviewtext != null)
			return reviewtext;
		else
			throw new RuntimeException("WalletHub review text is not specified in the config file");
	}
}

