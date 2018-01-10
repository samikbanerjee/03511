package org.TestCases;

import static org.junit.Assert.assertEquals;
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

import testFramework.tools.DataReaderServices.ReadProperties;



public class MyAccountLogIn
{
	private WebDriver driver;
	private String baseUrl;
	private String urlSfx;
	private String usrNm;
	private String usrPwd;
	private String testAddressLink;
	private String testSignOutLink;
	private boolean acceptNextAlert = true;
	private final StringBuffer verificationErrors = new StringBuffer();
	private ReadProperties rdr;

	@Before
	public void setUp() throws Exception
	{
		rdr = new ReadProperties("testMyAccountLogIn.properties");
		driver = new FirefoxDriver();
		baseUrl = rdr.getValue("baseUrl", "null");
		urlSfx = rdr.getValue("urlSfx", "null");
		usrNm = rdr.getValue("usrNm", "null");
		usrPwd = rdr.getValue("usrPwd", "null");
		testAddressLink = rdr.getValue("testAddressLink", "null");
		testSignOutLink = rdr.getValue("testSignOutLink", "null");
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
		try
		{
			assertEquals(testAddressLink, driver.findElement(By.linkText("Address Book")).getText());
		}
		catch (final Error e)
		{
			verificationErrors.append(e.toString());
		}
		try
		{
			assertEquals(testSignOutLink, driver.findElement(By.linkText("Sign Out")).getText());
			System.out.println(driver.findElement(By.linkText("Sign Out")).getText());
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
