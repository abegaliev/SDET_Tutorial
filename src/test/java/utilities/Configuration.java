package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Customized class by author, which helps with configuration of the framework
 * by reading properties file.
 *
 * @author Almazbek Begaliev
 *
 */
public final class Configuration {

	private static Properties configFile;
	private final static String fileName = "./src/test/resources/testData/configuration.properties"; // file
																										// path
	static {

		try {
			FileInputStream input = new FileInputStream(fileName);
			configFile = new Properties();
			configFile.load(input);

			input.close();
		} catch (FileNotFoundException e) {
			System.err.println("Could't find properties file: " + fileName + ":\n" + e);

		} catch (IOException e) {
			System.out.println("Exception while reading the file: " + fileName);
		}
	}

	/**
	 * Method returns a value of the given key from properties file.
	 * 
	 * @param String key
	 * @return String value of the key
	 */
	public static String getProperty(String key) {
		String value = configFile.getProperty(key);
		return value;
	}

}