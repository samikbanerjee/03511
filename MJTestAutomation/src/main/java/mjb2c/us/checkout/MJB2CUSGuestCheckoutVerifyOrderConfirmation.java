package mjb2c.us.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class MJB2CUSGuestCheckoutVerifyOrderConfirmation
{
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private final StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		baseUrl = "http://usmauijim.stg/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMJB2CUSGuestCheckoutVerifyOrderConfirmation() throws Exception
	{
		// Please open US site in a firefox browser and go through the other comments below (if any) before running this test script.
		driver.get(baseUrl + "/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SHOP")).click();
		driver.findElement(By.cssSelector("img[alt=\"Logo\"]")).click();
		driver.findElement(By.linkText("SHOP ALL SUNGLASSES")).click();
		driver.findElement(By.id("responsiveImage")).click();
		driver.findElement(By.id("addToCartButton")).click();
		driver.findElement(By.cssSelector("button.btn.button-orange")).click();
		driver.findElement(By.xpath(".//*[@id='addToGiftCartForm']/div[1]/div[1]/div/div/a")).click();
		driver.findElement(By.cssSelector("button.add-gift-bag-bt")).click();
		driver.findElement(By.cssSelector("div.order-summary-action > a.cta-1")).click();
		// Please change email address below. Tip: Use a new email address.
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("kamaljeet@pragiti.com");
		driver.findElement(By.id("registerInterceptSubmitButton")).click();
		assertEquals("CHECKOUT", driver.findElement(By.cssSelector("h1.checkout-title")).getText());
		assertTrue(isElementPresent(By.cssSelector("h2.checkout-sub-title")));
		try
		{
			assertTrue(isElementPresent(By.xpath("//div[@id='shippingDiv']/div[4]/h2")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.id("continue-address-btn")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
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
		try
		{
			assertTrue(isElementPresent(By.cssSelector("h3.address-modal-title")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.id("suggest-address-btn")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("suggest-address-btn")).click();
		try
		{
			assertEquals("SHIPPING METHOD", driver.findElement(By.cssSelector("div.shipping-method > h2.checkout-sub-title"))
					.getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.cssSelector("div.shipping-method > h2.checkout-sub-title")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		assertEquals("View Shipping Information", driver.findElement(By.cssSelector("a.view-shipp-info-a > p")).getText());
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
		driver.findElement(By.xpath(".//*[@id='shippingMethods']/div/div[1]/div[2]/div/a")).click();
		driver.findElement(By.id("shipping-button")).click();
		assertEquals("PAYMENT METHOD", driver.findElement(By.cssSelector("h2.checkout-sub-title")).getText());
		try
		{
			assertTrue(isElementPresent(By.cssSelector("div.shopping-bag > h2.checkout-sub-title")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
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
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
		driver.findElement(By.xpath(".//*[@id='billing-info-fields']/div/div[1]/div/a")).click();
		try
		{
			assertEquals("KAMALJEET", driver.findElement(By.id("firstname")).getAttribute("value"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("SINGH", driver.findElement(By.id("lastname")).getAttribute("value"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("4010 MOORPARK AVE", driver.findElement(By.id("address1")).getAttribute("value"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("SAN JOSE", driver.findElement(By.id("city")).getAttribute("value"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("95117-4101", driver.findElement(By.id("zip")).getAttribute("value"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("1234567890", driver.findElement(By.id("phone")).getAttribute("value"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		// ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
		try
		{
			assertEquals("3", driver.findElement(By.cssSelector("div.step-list.active > #stepUrlId > span")).getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.cssSelector("div.checkbox.checkbox-terms > label")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("termChkBoxLarge")).click();
		driver.findElement(By.cssSelector("button.review-page-bt-a")).click();
		try
		{
			assertEquals("MAHALO FOR YOUR ORDER, KAMALJEET", driver.findElement(By.cssSelector("h1.checkout-title")).getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("YOUR RECEIPT", driver.findElement(By.cssSelector("h1.checkout-sub-title")).getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(driver.findElement(By.cssSelector("h3.checkout-sub-title.hidden-xs")).getText()
					.matches("^exact:NEED TO CREATE AN ACCOUNT[\\s\\S]$"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(driver.findElement(By.cssSelector("h4.title")).getText().matches("^exact:Need Assistance[\\s\\S]$"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("SHIPPING INFORMATION", driver.findElement(By.cssSelector("h2.checkout-sub-title")).getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("BILLING INFORMATION", driver.findElement(By.xpath("//div[@id='pageContent']/div[2]/div/div[2]/div[2]/h1"))
					.getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("Sign up to receive email updates and information.",
					driver.findElement(By.xpath("//form[@id='guestRegisterForm']/div/div[7]/div/label")).getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals("CREATE AN ACCOUNT", driver.findElement(By.id("guestRegisterFormButton")).getAttribute("value"));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.xpath("//div[@id='pageContent']/div[2]/div/div[2]/div[3]/p")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.xpath("//div[@id='pageContent']/div[2]/div/div[2]/div[3]/p[2]")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.xpath("//div[@id='pageContent']/div[2]/div/div[2]/div[3]/p[3]")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertTrue(isElementPresent(By.cssSelector("p.total")));
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception
	{
		driver.quit();
		final String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString))
		{
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(final By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch (final NoSuchElementException e)
		{
			return false;
		}
	}

	@SuppressWarnings("unused")
	private boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (final NoAlertPresentException e)
		{
			return false;
		}
	}

	@SuppressWarnings("unused")
	private String closeAlertAndGetItsText()
	{
		try
		{
			final Alert alert = driver.switchTo().alert();
			final String alertText = alert.getText();
			if (acceptNextAlert)
			{
				alert.accept();
			}
			else
			{
				alert.dismiss();
			}
			return alertText;
		}
		finally
		{
			acceptNextAlert = true;
		}
	}
}
