package mjb2c.us.registration;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 *
 */
public class MJB2CUSForgotPasswordEmailSend
{

	//ForgotPasswordEmailSend - Test Data
	private static final String COUNTRY_SELECTOR = "UNITED STATES (English)";
	private static final String VALID_EMAIL = "mjaqatest@pragiti.com";

	/**
	 * @param driver
	 * @param baseUrl
	 * @throws Exception
	 */
	public void testMJB2CUSForgotPasswordEmailSend(final WebDriver driver, final String baseUrl) throws Exception
	{
		driver.get(baseUrl + "/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/div[2]/div[1]/ul[1]/li[2]/a")).click();
		driver.findElement(By.linkText(COUNTRY_SELECTOR)).click();
		driver.findElement(By.linkText("User")).click();
		driver.findElement(By.linkText("FORGOT PASSWORD?")).click();
		Thread.sleep(2000);
		assertEquals("RESET PASSWORD", driver.findElement(By.cssSelector("div.reset-password-overlay-head > h2")).getText());
		assertEquals("Email Address", driver.findElement(By.cssSelector("#forgottenPwdForm > div.form-group > label")).getText());
		driver.findElement(By.id("forgottenPwd.email")).clear();
		driver.findElement(By.id("forgottenPwd.email")).sendKeys(VALID_EMAIL);
		driver.findElement(By.id("resetPasswordFormButton")).click();
		Thread.sleep(2000);
		assertEquals("You have been sent an email with a link to change your password.", driver.findElement(By.id("validEmail"))
				.getText());

		driver.findElement(By.id("cboxClose")).click();
	}
}
