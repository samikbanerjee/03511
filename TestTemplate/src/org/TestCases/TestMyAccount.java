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

import testFramework.tools.DataReaderServices.ReadProperties;
import testFramework.tools.WebdriverFunctions.SelectBrowser;


@SuppressWarnings("javadoc")
public class TestMyAccount
{

	private WebDriver driver;
	private Logger log=LogManager.getLogger();
	private String baseUrl;
	private String urlSfx;
	private String usrNm;
	private String usrPwd;
	private String verifyEmail;
	private boolean acceptNextAlert = true;
	private final StringBuffer verificationErrors = new StringBuffer();
	private ReadProperties rdr;

	@Before
	public void setUp() throws Exception
	{
		rdr = new ReadProperties("testMyAccount.properties");
		final String browserName = System.getProperty("browserName");
		final String driverPath = System.getProperty("driverPath");
		driver = SelectBrowser.setDriver(browserName, driverPath);
		baseUrl = rdr.getValue("baseUrl", "null");
		urlSfx = rdr.getValue("urlSfx", "null");
		usrNm = rdr.getValue("usrNm", "null");
		usrPwd = rdr.getValue("usrPwd", "null");
		verifyEmail = rdr.getValue("verifyEmail", "null");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMyAccountLogIn() throws Exception
	{
		driver.get(baseUrl + urlSfx);
		driver.findElement(By.linkText("Sign in / Register")).click();
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys(usrNm);
		driver.findElement(By.id("j_password")).clear();
		driver.findElement(By.id("j_password")).sendKeys(usrPwd);
		driver.findElement(By.cssSelector("button.positive")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Address Book")).click();
		driver.findElement(By.linkText("Payment Details")).click();
		driver.findElement(By.linkText("Order History")).click();
		driver.findElement(By.linkText("Profile")).click();
		try
		{
			assertEquals(verifyEmail,
					driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/table/tbody/tr[4]/td[2]")).getText());
			log.info("Logged In");
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
			log.error(e.toString());
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
