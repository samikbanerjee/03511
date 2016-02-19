package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author samik
 */
public class Aexec
{
	private static final String url = "http://www.google.com";

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException
	{
		final WebDriver _dr = new FirefoxDriver();
		_dr.get(url);
		Thread.sleep(5000);
		_dr.quit();
	}
}
