/**
 *
 */
package mjb2c.testRunner;

import java.util.concurrent.TimeUnit;

import mjb2c.ca.registration.MJB2CCAForgotPasswordEmailSend;
import mjb2c.ca.registration.MJB2CCALoginValidUser;
import mjb2c.ca.registration.MJB2CCAOpenForgotPasswordPage;
import mjb2c.ca.registration.MJB2CCAReg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author Samik
 */
public class MJB2CCASmokeTestCases
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
		baseUrl = "http://camauijim.stg/";
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
	 * Site : MJ B2C CA; Scenario - Registration
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCAReg() throws Exception
	{
		new MJB2CCAReg().testMJB2CCAReg(driver, baseUrl);
	}


	/**
	 * <p>
	 * Site: MJ B2C CA; Scenario -Registration (ForgotPasswordEmailSend)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCAForgotPasswordEmailSend() throws Exception
	{
		new MJB2CCAForgotPasswordEmailSend().testMJB2CCAForgotPasswordEmailSend(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site: MJ B2C CA; Scenario - Registration(LoginValidUser)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCALoginValidUser() throws Exception
	{
		new MJB2CCALoginValidUser().testMJB2CCALoginValidUser(driver, baseUrl);
	}



	/**
	 * <p>
	 * Site: Site: MJ B2C CA; Scenario - OpenForgotPasswordPage
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CCAOpenForgotPasswordPage() throws Exception
	{
		new MJB2CCAOpenForgotPasswordPage().testMJB2CCAOpenForgotPasswordPage(driver, baseUrl);
	}


}
