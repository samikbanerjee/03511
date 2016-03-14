package mjb2c.ca.registration;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tools.Utilities;


/**
 *
 */
public class MJB2CCAReg
{
	//Registration Data
	private static final String COUNTRY_SELECTOR = "CANADA (English)";
	private static final String CUST_PASS = "Qwerty@1234";
	private static final String CUST_EMAIL = "mjaqatest" + Utilities.dateTimeStamp() + "@pragiti.com";
	private static final String CUST_LNAME = "mj";
	private static final String CUST_FNAME = "mjaqatest";


	/**
	 * @param driver
	 * @param baseUrl
	 * @throws Exception
	 */
	public void testMJB2CCAReg(final WebDriver driver, final String baseUrl) throws Exception
	{
		driver.get(baseUrl + "/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/div[2]/div[1]/ul[1]/li[2]/a")).click();
		driver.findElement(By.linkText(COUNTRY_SELECTOR)).click();
		driver.findElement(By.linkText("User")).click();
		driver.findElement(By.linkText("User")).click();
		driver.findElement(By.id("register.firstName")).clear();
		driver.findElement(By.id("register.firstName")).sendKeys(CUST_FNAME);
		driver.findElement(By.id("register.lastName")).clear();
		driver.findElement(By.id("register.lastName")).sendKeys(CUST_LNAME);
		driver.findElement(By.id("register_email")).clear();
		driver.findElement(By.id("register_email")).sendKeys(CUST_EMAIL);
		driver.findElement(By.id("confEmail")).click();
		driver.findElement(By.id("confEmail")).clear();
		driver.findElement(By.id("confEmail")).sendKeys(CUST_EMAIL);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(CUST_PASS);
		driver.findElement(By.id("register.checkPwd")).clear();
		driver.findElement(By.id("register.checkPwd")).sendKeys(CUST_PASS);
		driver.findElement(By.cssSelector("#registerSubmitButton > input.cta-1")).click();
		assertEquals("Thank you for registering.", driver.findElement(By.cssSelector("div.alert-checkbalance")).getText());
		driver.findElement(By.linkText("Logout")).click();

	}


}
