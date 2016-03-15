package mjb2c.us.registration;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 *
 */
public class MJB2CUSLoginValidUser
{
	//LoginValidUser Test Data
	private static final String CUST_PASS = "Qwerty@1234";
	private static final String CUST_EMAIL = "mjaqatest@pragiti.com";
	private static final String COUNTRY_SELECTOR = "UNITED STATES (English)";

	/**
	 * @param driver
	 * @param baseUrl
	 * @throws Exception
	 */
	public void testMJB2CUSLoginValidUser(final WebDriver driver, final String baseUrl) throws Exception
	{
		driver.get(baseUrl + "/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/div[2]/div[1]/ul[1]/li[2]/a")).click();
		driver.findElement(By.linkText(COUNTRY_SELECTOR)).click();
		driver.findElement(By.linkText("User")).click();
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys(CUST_EMAIL);
		driver.findElement(By.id("j_password")).clear();
		driver.findElement(By.id("j_password")).sendKeys(CUST_PASS);
		driver.findElement(By.cssSelector("input.cta-1")).click();
		assertEquals("Sunglasses designed to change the way you see the world..", driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}


}
