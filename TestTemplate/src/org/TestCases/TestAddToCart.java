package org.TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import testFramework.tools.DataReaderServices.ReadProperties;
import testFramework.tools.WebdriverFunctions.SelectBrowser;


/**
 * Test of Add To cart
 */
public class TestAddToCart
{
	private WebDriver driver;
	private Logger log=LogManager.getLogger();
	private String baseUrl;
	private String URL_SFX;
	private String PROD_NM;
	private boolean acceptNextAlert = true;
	private final StringBuffer verificationErrors = new StringBuffer();
	private ReadProperties rdr;

	@Before
	public void setUp() throws Exception
	{
		rdr = new ReadProperties("testATC.properties");
		final String browserName = System.getProperty("browserName");
		final String driverPath = System.getProperty("driverPath");
		driver = SelectBrowser.setDriver(browserName, driverPath);
		baseUrl = rdr.getValue("base.url", "null");
		URL_SFX = rdr.getValue("url.sfx", "null");
		PROD_NM = rdr.getValue("prod.nm", "null");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testAddToCart() throws Exception
	{
		driver.get(baseUrl + URL_SFX);
		final Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Brands"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("Brands"))).moveToElement(driver.findElement(By.linkText("Canon")))
				.click().build().perform();
		driver.findElement(By.cssSelector("img[alt=\"GR-80TP Extension Battery Grip/Tripod\"]")).click();
		driver.findElement(By.id("addToCartButton")).click();
		driver.findElement(By.cssSelector("a.minicart")).click();
		try
		{
			assertEquals(PROD_NM, driver.findElement(By.xpath("//div[@id='cartItems']/table/tbody/tr/td[2]")).getText());
			log.info("Added to Cart");
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
			log.error(e.toString());
		}
	}

	/**
	 * @throws Exception
	 */
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

	@SuppressWarnings("unused")
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
