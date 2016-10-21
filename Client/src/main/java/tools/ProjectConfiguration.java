package tools;

import java.io.IOException;
import java.util.Properties;


/**
 * @author samik
 */
public class ProjectConfiguration
{
	Properties prop;

	/**
	 * @param propertiesFile
	 * @throws IOException
	 */
	public ProjectConfiguration(final String propertiesFile) throws IOException
	{
		prop = new Properties();
		prop.load(ProjectConfiguration.class.getClassLoader().getResourceAsStream(propertiesFile));
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
