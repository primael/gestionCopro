package fr.nimroad.gestcopro.app.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import lombok.Cleanup;
import lombok.SneakyThrows;

public enum PropertiesGetValue {

	CONFIG("application-config-env.properties");
	
	private final Properties properties;
	
	@SneakyThrows
	private PropertiesGetValue(String propFileName){
		properties = new Properties();

		@Cleanup InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
	}
	
	public String getValue(String key){
		return this.properties.getProperty(key);
	}
}
