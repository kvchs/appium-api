package appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenOrientation {
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
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void performOrientation() throws InterruptedException {
		// Get and print current screen orientation.
		System.out.println("*--*--*-- Current screen orientation Is : "
				+ driver.getOrientation());
		System.out
				.println("*--*--*-- Changing screen Orientation to LANDSCAPE.");
		// Changing screen Orientation to LANDSCAPE.
		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : "
				+ driver.getOrientation());
		Thread.sleep(5000);
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
//		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.xpath("//android.widget.TextView[text='Views']")).click();
		System.out
				.println("*--*--*-- Changing screen Orientation to PORTRAIT.");
		// Changing screen Orientation to PORTRAIT.
		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : "
				+ driver.getOrientation());
		Thread.sleep(5000);
	}

	@AfterTest
	public void End() throws IOException {
		driver.quit();
		// Stop appium server when test Is ended.
		appiumStop();
	}
}
