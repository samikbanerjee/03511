/**
 *
 */
package mjb2c.testRunner;

import java.util.concurrent.TimeUnit;

import mjb2c.us.registration.MJB2CUSForgotPasswordEmailSend;
import mjb2c.us.registration.MJB2CUSLoginValidUser;
import mjb2c.us.registration.MJB2CUSOpenForgotPasswordPage;
import mjb2c.us.registration.MJB2CUSReg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 *
 */
public class MJB2CSmokeTestCases
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
		baseUrl = "http://usmauijim.stg/";
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
	 * Site: MJ B2C US; Scenario - Registration
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CUSReg() throws Exception
	{
		new MJB2CUSReg().testMJB2CUSReg(driver, baseUrl);
	}



	/**
	 * <p>
	 * Site: MJ B2C US; Scenario - Registration(ForgotPasswordEmailSend)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CUSForgotPasswordEmailSend() throws Exception
	{
		new MJB2CUSForgotPasswordEmailSend().testMJB2CUSForgotPasswordEmailSend(driver, baseUrl);
	}

	/**
	 * <p>
	 * Site: MJ B2C US; Scenario - Registrtion (LoginValidUser)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CUSLoginValidUser() throws Exception
	{
		new MJB2CUSLoginValidUser().testMJB2CUSLoginValidUser(driver, baseUrl);
	}


	/**
	 * <p>
	 * Site: MJ B2C US; Scenario - Registration (OpenForgotPasswordPage)
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testMJB2CUSOpenForgotPasswordPage() throws Exception
	{
		new MJB2CUSOpenForgotPasswordPage().testMJB2CUSOpenForgotPasswordPage(driver, baseUrl);
	}



	/**
	 * <p>
	 * Site : MJ B2C CA; Scenario - Registration
	 * </p>
	 *
	 * @throws Exception
	 */
	//	@Test
	//	public void testMJB2CCAReg() throws Exception
	//	{
	//		new MJB2CCAReg().testMJB2CCAReg(driver, baseUrl);
	//	}


	//TODO: Site: MJ B2C CA; Scenario - ForgotPasswordEmailSend

	//TODO: Site: MJ B2C CA; Scenario - LoginValidUser

	//TODO: Site: MJ B2C CA; Scenario - Logout

	//TODO: Site: MJ B2C CA; Scenario - OpenForgotPasswordPage


}
