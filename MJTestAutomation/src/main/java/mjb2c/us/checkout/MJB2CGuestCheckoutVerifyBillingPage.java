package mjb2c.us.checkout;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MJB2CGuestCheckoutVerifyBillingPage {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://usmauijim.stg";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMJB2CGuestCheckoutVerifyBillingPage() throws Exception {
    // Please open US site in a firefox browser and go through the other comments below (if any) before running this test script.
    driver.get(baseUrl+"/en/");
    driver.manage().window().maximize();
    Thread.sleep(2000);
    //driver.findElement(By.xpath(".//*[@id='slidemenu']/div[1]/ul[2]/li[1]/a")).click();
    driver.findElement(By.linkText("SHOP")).click();
    driver.findElement(By.cssSelector("img[alt=\"Logo\"]")).click();
    driver.findElement(By.linkText("SHOP ALL SUNGLASSES")).click();
    Thread.sleep(40000);
    driver.findElement(By.id("responsiveImage")).click();
    driver.findElement(By.id("addToCartButton")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("button.btn.button-orange")).click();
    driver.findElement(By.xpath(".//*[@id='addToGiftCartForm']/div[1]/div[1]/div/div/a")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath(".//*[@id='addToGiftCartForm']/div[1]/div[2]/button")).click();
    driver.findElement(By.cssSelector("button.add-gift-bag-bt")).click();
    driver.findElement(By.xpath(".//*[@id='pageContent']/div/div[4]/div[1]/div[3]/div[2]/div/div/div[2]/a")).click();
    /*driver.findElement(By.cssSelector("div.order-summary-action < a.cta-1")).click();*/
    // Please change email address below. Tip: Use a new email address.
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email Address")).sendKeys("kamaljeet@pragiti.com");
    driver.findElement(By.id("RegisterInterceptSubmitButton")).click();
    assertEquals("CHECKOUT", driver.findElement(By.cssSelector("h1.Checkout-title")).getText());
    assertTrue(isElementPresent(By.cssSelector("h2.Checkout-sub-title")));
    assertTrue(isElementPresent(By.xpath("//div[@id='shippingDiv']/div[4]/h2")));
    assertTrue(isElementPresent(By.id("continue-address-btn")));
    driver.findElement(By.id("address-FirstName")).clear();
    driver.findElement(By.id("address-FirstName")).sendKeys("Kamaljeet");
    driver.findElement(By.id("address-LastName")).clear();
    driver.findElement(By.id("address-LastName")).sendKeys("Singh");
    driver.findElement(By.id("address-Line1")).clear();
    driver.findElement(By.id("address-Line1")).sendKeys("4010 Moorpark Ave");
    driver.findElement(By.id("address-Town")).clear();
    driver.findElement(By.id("address-Town")).sendKeys("San Jose");
    new Select(driver.findElement(By.id("regionIso"))).selectByVisibleText("CALIFORNIA");
    driver.findElement(By.id("address-Zip")).clear();
    driver.findElement(By.id("address-Zip")).sendKeys("95117");
    driver.findElement(By.id("address-Phone")).clear();
    driver.findElement(By.id("address-Phone")).sendKeys("1234567890");
    driver.findElement(By.id("continue-address-btn")).click();
    Thread.sleep(30000);
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    assertTrue(isElementPresent(By.cssSelector("h3.address-modal-title")));
    assertTrue(isElementPresent(By.id("suggest-address-btn")));
    driver.findElement(By.id("suggest-address-btn")).click();
   
      assertEquals("SHIPPING METHOD", driver.findElement(By.cssSelector("div.shipping-method > h2.checkout-sub-title")).getText());
   
    Thread.sleep(20000);
    
      assertTrue(isElementPresent(By.cssSelector("div.shipping-method > h2.checkout-sub-title")));
    
    assertEquals("View Shipping Information", driver.findElement(By.cssSelector("a.view-shipp-info-a > p")).getText());
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath(".//*[@id='shippingMethods']/div/div[1]/div[2]/div/a")).click();
    driver.findElement(By.id("shipping-button")).click();
    assertEquals("PAYMENT METHOD", driver.findElement(By.cssSelector("h2.checkout-sub-title")).getText());
   
      assertTrue(isElementPresent(By.cssSelector("div.shopping-bag > h2.checkout-sub-title")));
   
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
	  System.out.println("Test Finished");
    
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
