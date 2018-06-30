package appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ControlSeekBar {
		AppiumServer appiumServer = new AppiumServer();
		AndroidDriver driver;

	// This method Is responsible for starting appium server.
	public void appiumStart() throws IOException, InterruptedException {
		
		appiumServer.startServer();
	}

	// This method Is responsible for stopping appium server.
	public void appiumStop() throws IOException {
		appiumServer.stopServer();
		System.out.println("Appium server Is stopped now.");
	}

	@BeforeTest
	public void setUp() throws Exception {
		// Stop appium server If It Is already running.
		appiumStop();
		// Start appium server.
		appiumStart();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZX1B32FFXF");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity",
				"io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void ScrollToView() {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
//		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.xpath("//android.widget.TextView[text='Views']")).click();
		// Scroll till element which contains "Seek Bar" text If It Is not
		// visible on screen.
//		driver.scrollTo("Seek Bar");
		// Click on Seek Bar.
		driver.findElement(By.xpath("//android.widget.TextView[text='Seek Bar']")).click();

		// Locate SeekBar element.
		WebElement seekBar = driver.findElementById("io.appium.android.apis:id/seek");
		// Get start point of seekbar.
		int startX = seekBar.getLocation().getX();
		System.out.println(startX);
		// Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();

		// Set sllebar move to position.
		// endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * 0.6);
		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

		// Moving seekbar using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(startX, yAxis).moveTo(moveToXDirectionAt, yAxis).release().perform();
	}

	@AfterTest
	public void End() throws IOException {
		driver.quit();
		// Stop appium server when test Is ended.
		appiumStop();
	}
}