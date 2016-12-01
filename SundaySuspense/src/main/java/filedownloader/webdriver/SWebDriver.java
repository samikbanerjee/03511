package filedownloader.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 *
 */
public class SWebDriver
{

	/**
	 * @return FireFoxDriver With Maronette Set False
	 */
	public static WebDriver FireFoxDriver()
	{
		final DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("marionette", false);
		cap.setBrowserName("firefox");

		final WebDriver dr = new FirefoxDriver(cap);
		return dr;
	}
}
