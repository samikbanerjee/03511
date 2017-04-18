package jira.Rest.Client;

import java.io.IOException;
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
		prop.load(PropertyReader.class.getClassLoader().getResourceAsStream(propertiesFile));
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
