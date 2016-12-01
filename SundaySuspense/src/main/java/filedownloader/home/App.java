/**
 *
 */
package filedownloader.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 *
 */
public class App
{


	private static final String dlLink = "http://www.google.com";//"http://bengalimp3download.in/Sunday%20Suspense/Chinepotka.mp3";
	private static final String dlLoc = "E:\\Downloads\\poc\\dl";

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException
	{
		final FirefoxProfile prof = new FirefoxProfile();
		//prof.setPreference("browser.download.folderList", 2);
		prof.setPreference("browser.download.manager.showWhenStarting", false);
		prof.setPreference("browser.download.dir", dlLoc);
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "audio/mpeg3");

		final DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("marionette", false);
		cap.setBrowserName("firefox");
		cap.setCapability(FirefoxDriver.PROFILE, prof);

		final WebDriver driver = new FirefoxDriver();
		driver.get(dlLink);
		Thread.sleep(1000);
		driver.quit();
	}

}
