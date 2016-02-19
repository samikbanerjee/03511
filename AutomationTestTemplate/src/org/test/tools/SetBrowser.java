/**
 *
 */
package org.test.tools;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



/**
 *
 */
public class SetBrowser
{
	/**
	 * @param browser
	 * @return set the Webdriver
	 * @throws IOException
	 */
	public static WebDriver WebDriver(final String browser) throws IOException
	{
		WebDriver _dr = null;
		final ReadProperties prop = new ReadProperties("browser-definition.properties");
		final String driverDir = System.getProperty("user.dir") + prop.getValue("webdriver.location");

		if (browser.trim().equalsIgnoreCase("Firefox"))
		{
			_dr = new FirefoxDriver();
		}

		if (browser.trim().equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverDir + prop.getValue("chromedriver"));
			_dr = new ChromeDriver();
		}

		if (browser.trim().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", driverDir + prop.getValue("iedriver"));
			_dr = new InternetExplorerDriver();
		}

		return _dr;
	}
}
