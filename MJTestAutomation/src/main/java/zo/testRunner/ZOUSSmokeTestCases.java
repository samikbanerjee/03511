/**
 *
 */
package zo.testRunner;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import zo.us.registration.ZOUSRegistration;


/**
 * @author Samik
 */
public class ZOUSSmokeTestCases
{
	private WebDriver driver;
	private String baseUrl;


	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		baseUrl = "http://uszealoptics.stg/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		driver.quit();
	}


	/**
	 * <p>
	 * Site : ZO US; Scenario - Registration
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testZOUSRegistration() throws Exception
	{
		new ZOUSRegistration().testZOUSRegistration(driver, baseUrl);
	}


}
