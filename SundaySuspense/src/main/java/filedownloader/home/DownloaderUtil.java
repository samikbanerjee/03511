package filedownloader.home;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import filedownloader.webdriver.SWebDriver;


/**
 * To get the Download Link
 */
public class DownloaderUtil
{

	private static final String startUrl = "http://bengalimp3download.in/Sunday-Suspense-sc-0-2.html";

	private static final Logger log = LogManager.getLogger();

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException
	{
		final WebDriver dr = SWebDriver.FireFoxDriver();
		dr.get(startUrl);
		Thread.sleep(2000);
		final List<WebElement> dEls = dr.findElements(By.xpath(".//*[@class='M3']//a"));
		for (final WebElement dEl : dEls)
		{
			final String s1 = dEl.getText();
			final String s2 = dEl.getAttribute("href");
			final String s3 = getDownloadLink(s2);
			log.info(s1 + "--" + s2 + "--" + s3);
		}
		dr.quit();
	}



	/**
	 * @param pUrl
	 * @return Get the Download Link
	 * @throws InterruptedException
	 */
	public static String getDownloadLink(final String pUrl) throws InterruptedException
	{
		final WebDriver dr = SWebDriver.FireFoxDriver();
		dr.get(pUrl);
		Thread.sleep(2000);
		final String dl = dr.findElement(By.xpath(".//a[@class='Download']")).getAttribute("href");
		dr.quit();
		return dl;
	}
}
