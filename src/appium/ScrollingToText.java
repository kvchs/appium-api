package appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollingToText {
	AndroidDriver driver;

	@BeforeTest
	public void setUp() throws Exception {

		// Set Drag-Sort Demos app folder path. This statement will refer
		// project's folder path.
		File classpathRoot = new File(System.getProperty("user.dir"));

		// Set folder name "Apps" where .apk file is stored.
		File appDir = new File(classpathRoot, "/apps");

		// Set Drag-Sort Demos .apk file name.
		File app = new File(appDir, "ApiDemos.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZX1B32FFXF");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity",
				"io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void ScrollToText() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views/.
		driver.findElement(By.name("Views")).click();
		System.out.println("Scrolling has been started to find text -> Tabs.");
		// Scroll till element which contains Tabs text.
		driver.scrollTo("Tabs");
		System.out.println("Tabs text has been found and now clicking on It.");
		// Click on Tabs.
		driver.findElement(By.name("Tabs")).click();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}