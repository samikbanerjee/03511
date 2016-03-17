package mjb2c.us.checkout;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class MJB2CGuestCheckoutVerifyOrderConfirmation
{
	private static final String Valid = null;

	public void testMJB2CGuestCheckoutVerifyOrderConfirmation(final WebDriver driver, final String baseUrl) throws Exception
	{
		// Please open US site in a firefox browser and go through the other comments below (if any) before running this test script.

		/*
		 * driver.get(baseUrl + "/"); driver.manage().window().maximize(); Thread.sleep(2000);
		 * driver.findElement(By.linkText("SHOP")).click();
		 * driver.findElement(By.cssSelector("img[alt=\"Logo\"]")).click();
		 * driver.findElement(By.linkText("SHOP ALL SUNGLASSES")).click();
		 * driver.findElement(By.id("responsiveImage")).click();
		 */

		driver.get(baseUrl + "/en/p/GS253-2M");

		//driver.manage().window().maximize();
		driver.findElement(By.id("addToCartButton")).click();
		driver.findElement(By.cssSelector("button.btn.button-orange")).click();
		driver.findElement(By.xpath(".//*[@id='addToGiftCartForm']/div[1]/div[1]/div/div/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='addToGiftCartForm']")).click();
		driver.findElement(By.cssSelector("button.add-gift-bag-bt")).click();
		driver.findElement(By.cssSelector("div.order-summary-action > a.cta-1")).click();
		// Login Intercep
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("kamaljeet@pragiti.com");
		driver.findElement(By.id("registerInterceptSubmitButton")).click();
		assertEquals("CHECKOUT", driver.findElement(By.cssSelector("h1.checkout-title")).getText());
		//Checkout Address
		driver.findElement(By.id("address-firstName")).clear();
		driver.findElement(By.id("address-firstName")).sendKeys("Kamaljeet");
		driver.findElement(By.id("address-lastName")).clear();
		driver.findElement(By.id("address-lastName")).sendKeys("Singh");
		driver.findElement(By.id("address-line1")).clear();
		driver.findElement(By.id("address-line1")).sendKeys("4010 Moorpark Ave");
		driver.findElement(By.id("address-town")).clear();
		driver.findElement(By.id("address-town")).sendKeys("San Jose");
		new Select(driver.findElement(By.id("regionIso"))).selectByVisibleText("CALIFORNIA");
		driver.findElement(By.id("address-zip")).clear();
		driver.findElement(By.id("address-zip")).sendKeys("95117");
		driver.findElement(By.id("address-phone")).clear();
		driver.findElement(By.id("address-phone")).sendKeys("1234567890");
		driver.findElement(By.id("continue-address-btn")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
		Thread.sleep(2000);
		driver.findElement(By.id("suggest-address-btn")).click();
		Thread.sleep(10000);
		assertEquals("SHIPPING METHOD", driver.findElement(By.cssSelector("div.shipping-method > h2.checkout-sub-title")).getText());
		assertEquals("View Shipping Information", driver.findElement(By.cssSelector("a.view-shipp-info-a > p")).getText());
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
		driver.findElement(By.xpath(".//*[@id='shippingMethods']/div")).click();
		driver.findElement(By.xpath(".//*[@id='shippingMethods']/div/div[1]/div[2]/div/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("shipping-button")).click();
		Thread.sleep(5000);
		assertEquals("PAYMENT METHOD", driver.findElement(By.cssSelector("h2.checkout-sub-title")).getText());
		//    driver.findElement(By.xpath(".//*[@id='ccins']")).click();
		//    driver.findElement(By.xpath(".//*[@class='valid'][contains(.,'VISA')]")).click();
		final WebElement delFrame = driver.findElement(By.id("partner-frame"));
		driver.switchTo().frame(delFrame);
		new Select(driver.findElement(By.id("ccins"))).selectByVisibleText("MasterCard");
		driver.findElement(By.id("ccname")).clear();
		driver.findElement(By.id("ccname")).sendKeys("Sunny");
		driver.findElement(By.id("ccnum_display")).sendKeys("5555555555554444");
		driver.findElement(By.id("expDateMonth")).clear();
		driver.findElement(By.id("expDateMonth")).sendKeys("01");
		driver.findElement(By.id("expDateYear")).clear();
		driver.findElement(By.id("expDateYear")).sendKeys("2022");
		driver.findElement(By.id("cvval_display")).sendKeys("123");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().defaultContent();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='billing-info-fields']/div/div[1]/div/a")).click();
		Thread.sleep(2000);
		assertEquals("KAMALJEET", driver.findElement(By.id("firstname")).getAttribute("value"));
		assertEquals("SINGH", driver.findElement(By.id("lastname")).getAttribute("value"));
		assertEquals("4010 MOORPARK AVE", driver.findElement(By.id("address1")).getAttribute("value"));
		assertEquals("SAN JOSE", driver.findElement(By.id("city")).getAttribute("value"));
		assertEquals("95117-4101", driver.findElement(By.id("zip")).getAttribute("value"));
		assertEquals("1234567890", driver.findElement(By.id("phone")).getAttribute("value"));
		Thread.sleep(2000);
		//final Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath(".//*[@id='paymentDetailsForm']/p/input"))).click().perform();
		driver.findElement(By.xpath(".//*[@id='paymentDetailsForm']/p/input")).sendKeys(Keys.RETURN);

		assertEquals("3", driver.findElement(By.cssSelector("div.step-list.active > #stepUrlId > span")).getText());

		driver.findElement(By.id("termChkBoxLarge")).click();
		driver.findElement(By.cssSelector("button.review-page-bt-a")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		assertEquals("MAHALO FOR YOUR ORDER, KAMALJEET", driver.findElement(By.cssSelector("h1.checkout-title")).getText());
		assertEquals("YOUR RECEIPT", driver.findElement(By.cssSelector("h1.checkout-sub-title")).getText());
		//		assertTrue(driver.findElement(By.cssSelector("h3.checkout-sub-title.hidden-xs")).getText()
		//				.matches("^exact:NEED TO CREATE AN ACCOUNT[\\s\\S]$"));
		//		assertTrue(driver.findElement(By.cssSelector("h4.title")).getText().matches("^exact:Need Assistance[\\s\\S]$"));

		assertEquals("SHIPPING INFORMATION", driver.findElement(By.cssSelector("h2.checkout-sub-title")).getText());

		assertEquals("BILLING INFORMATION", driver.findElement(By.xpath("//div[@id='pageContent']/div[2]/div/div[2]/div[2]/h1"))
				.getText());

		assertEquals("Sign up to receive email updates and information.",
				driver.findElement(By.xpath("//form[@id='guestRegisterForm']/div/div[7]/div/label")).getText());

		assertEquals("CREATE AN ACCOUNT", driver.findElement(By.id("guestRegisterFormButton")).getAttribute("value"));



	}

	public static void main(final String[] args) throws Exception
	{
		final WebDriver driver = new FirefoxDriver();
		final String baseUrl = "http://usmauijim.stg";
		new MJB2CGuestCheckoutVerifyOrderConfirmation().testMJB2CGuestCheckoutVerifyOrderConfirmation(driver, baseUrl);
	}
}
