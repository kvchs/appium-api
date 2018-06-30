//necessary:https://sqa.stackexchange.com/questions/24444/unable-to-scroll-and-click-as-element-is-not-visible-in-selenium-with-native-an

package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetStarRating {
	AndroidDriver driver;
	
	protected  void scrollToElementByTextContains(String text) {
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
	            ".scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0));");
	    
	    
	}

	protected void  srollToElementByResourceId(String regex) {
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
	            ".scrollIntoView(new UiSelector().resourceIdMatches(\".*" + regex + "\").instance(0));");
	            
	}
	public void hoverOverElementAndClick(WebElement element) {
		  Actions action = new Actions(driver);
		  action.moveToElement(element).perform();
		  element.click();
		}

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZX1B32FFXF");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity",
				"io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		// driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(
				By.xpath("//android.widget.TextView[@content-desc='Views']"))
				.click();
		// Scroll till element which contains "Rating Bar" text If It Is not
		// visible on screen.
		// driver.scrollTo("Rating Bar");
		// Click on Rating Bar.
//		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Rating Bar']"));
//		Actions action = new Actions(driver);
//		  action.moveToElement(element).perform();
//		  element.click();
//		WebElement element2 = driver.findElement(By.xpath("//android.widget.TextView[@text='Focus']"));
//		WebElement element3 = driver.findElement(By.xpath("//android.widget.TextView[@text='ImageView']"));
//		  
//		  hoverOverElementAndClick(element2);
//		  hoverOverElementAndClick(element3);
//		  hoverOverElementAndClick(element);
		scrollToElementByTextContains("Rating Bar");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Rating Bar']")).click();
		
	}

	// Set 3 StarRatingbar = 1 star.
	@Test
	public void set3StarRatingbar() {
		// Locate threeStarRatingbar.
		WebElement threeStarRatingbar = driver.findElement(By
				.id("io.appium.android.apis:id/ratingbar1"));
		// Get start point of threeStarRatingbar.
		int startX = threeStarRatingbar.getLocation().getX();
		System.out.println(startX);
		// Get end point of threeStarRatingbar.
		int endX = threeStarRatingbar.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of threeStarRatingbar.
		int yAxis = threeStarRatingbar.getLocation().getY();

		// Set threeStarRatingbar tap position to set Rating = 1 star.
		// You can use endX * 0.3 for 1 star, endX * 0.6 for 2 star, endX * 1
		// for 3 star.
		int tapAt = (int) (endX * 0.3);
		// Set threeStarRatingbar to Rating = 1.0 using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(tapAt, yAxis).release().perform();
	}

	// Set 5 StarRatingbar = 4 star.
	@Test
	public void set5StarRatingbar() {
		// Locate fiveStarRatingbar.
		WebElement fiveStarRatingbar = driver.findElement(By
				.id("io.appium.android.apis:id/ratingbar2"));
		// Get start point of fiveStarRatingbar.
		int startX = fiveStarRatingbar.getLocation().getX();
		System.out.println(startX);
		// Get end point of fiveStarRatingbar.
		int endX = fiveStarRatingbar.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of fiveStarRatingbar.
		int yAxis = fiveStarRatingbar.getLocation().getY();

		// Set fiveStarRatingbar tap position to set Rating = 4 star.
		// You can use endX * 0.2 for 1 star, endX * 0.4 for 2 star, endX * 0.6
		// for 3 star, endX * 0.8 for 4 star, endX * 1 for 5 star.
		int tapAt = (int) (endX * 0.8);
		// Set fiveStarRatingbar to Rating = 4 star using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(tapAt, yAxis).release().perform();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}
