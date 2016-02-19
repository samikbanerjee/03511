package org.test.tools;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


/**
 * @author Samik
 */
public class ReadProperties
{
	Properties prop;

	/**
	 * @param propertiesFileName
	 * @throws IOException
	 */
	public ReadProperties(final String propertiesFileName) throws IOException
	{
		prop = new Properties();
		prop.load(ReadProperties.class.getClassLoader().getResourceAsStream(propertiesFileName));


	}

	/**
	 * @param key
	 * @return Searches for the property with the specified key in this property list. The method returns null if the
	 *         property is not found.
	 */
	public String getValue(final String key)
	{
		return prop.getProperty(key);
	}


	/**
	 * @param key
	 * @param defaultValue
	 * @return Searches for the property with the specified key in this property list. If the key is not found in this
	 *         property list, the default property list, and its defaults, recursively, are then checked. The method
	 *         returns null if the property is not found.
	 */
	public String getValue(final String key, final String defaultValue)
	{
		return prop.getProperty(key, defaultValue);
	}


	/**
	 * @return Returns a Set view of the keys contained in this map.
	 */
	public Set<String> keySet()
	{
		final Set<String> keySetString = new HashSet<String>();

		final Set<Object> keySet = prop.keySet();
		for (final Object key : keySet)
		{
			keySetString.add(key.toString());
		}
		return keySetString;
	}
}
