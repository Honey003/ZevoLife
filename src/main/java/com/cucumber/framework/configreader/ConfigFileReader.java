package com.cucumber.framework.configreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;

	String currentDirectory = System.getProperty("user.dir");
	String propertyFilePath = currentDirectory + "/src/main/java/resources/config.properties";

	
	
	
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
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String userName() {
		String superAdminUsername = properties.getProperty("superAdminUsername");
		if (superAdminUsername != null)
			return superAdminUsername;
		else
			throw new RuntimeException("superAdminUsername not specified in the Configuration.properties file.");
	}

	public String password() {
		String superAdminPassword = properties.getProperty("superAdminPassword");
		if (superAdminPassword != null)
			return superAdminPassword;
		else
			throw new RuntimeException("superAdminPassword not specified in the Configuration.properties file.");
	}

	public String companyAdminName() {
		String companyAdminUsername = properties.getProperty("companyAdminUsername");
		if (companyAdminUsername != null)
			return companyAdminUsername;
		else
			throw new RuntimeException("superAdminUsername not specified in the Configuration.properties file.");
	}

	public String companyAdminPassword() {
		String companyAdminPassword = properties.getProperty("companyAdminPassword");
		if (companyAdminPassword != null)
			return companyAdminPassword;
		else
			throw new RuntimeException("companyAdminPassword not specified in the Configuration.properties file.");
	}

}