package org.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.test.tools.SetBrowser;


/**
 * @author samik
 */
public class Aexec
{
	private static final String url = "http://www.google.com";
	private static final String browser = "chrome";

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(final String[] args) throws InterruptedException, IOException
	{
		final WebDriver _dr = SetBrowser.WebDriver(browser);
		_dr.get(url);
		Thread.sleep(5000);
		_dr.quit();
	}
}
