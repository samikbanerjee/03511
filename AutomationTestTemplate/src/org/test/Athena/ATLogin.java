package org.test.Athena;

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
import org.test.tools.SetBrowser;


/**
 *
 */
public class ATLogin
{
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private final StringBuffer verificationErrors = new StringBuffer();

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		driver = SetBrowser.WebDriver("chrome");
		baseUrl = "http://www.amway-qas.com.br/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testATLogin() throws Exception
	{
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("//div[@id='mainbody']/section[2]/div/a")).click();
		driver.findElement(By.xpath("//input[@id='j_username']")).clear();
		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("reg1022");
		driver.findElement(By.xpath("//input[@id='j_password']")).clear();
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='login-checkout']")).click();
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
