package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

	private static Properties properties = new Properties();

	static {
		try (InputStream input = ReadConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (input == null) {
				throw new RuntimeException("Sorry, unable to find config.properties");
			}
			properties.load(input);
		} catch (IOException ex) {
			throw new RuntimeException("Failed to load configuration properties", ex);
		}
	}
	
	public static String getProperty(String name) {
		return properties.getProperty(name);
	}
}
