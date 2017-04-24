package jira.Rest.Client;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;


/**
 * @author samik
 */
public class PropertyReader
{
	Properties prop;

	/**
	 * @param propertiesFile
	 * @throws IOException
	 */
	public PropertyReader(final String propertiesFile) throws IOException
	{
		prop = new Properties();
		final Reader reader = new FileReader(System.getProperty("user.dir") + "/resources/" + propertiesFile);
		prop.load(reader);
	}

	/**
	 * @param propertyKey
	 * @return property value
	 */
	public String getPropertyValue(final String propertyKey)
	{
		return prop.getProperty(propertyKey);
	}

	/**
	 * @param propertyKey
	 * @param defaultVal
	 * @return property value or default value
	 */
	public String getPropertyValue(final String propertyKey, final String defaultVal)
	{
		return prop.getProperty(propertyKey, defaultVal);
	}
}
