package appium;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectingRadioButton {
	AndroidDriver driver;

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
	}

	@Test
	public void typeInText() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		// driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(
				By.xpath("//android.widget.TextView[@content-desc='Views']"))
				.click();

		// Scroll till element which contains "Controls" text If It Is not
		// visible on screen.
		// driver.scrollTo("Controls");
		// Click on Controls.
		driver.findElement(
				By.xpath("//android.widget.TextView[@text='Controls']"))
				.click();
		// Scroll till element which contains "2. Dark Theme" text If It Is not
		// visible on screen.
		// driver.scrollTo("2. Dark Theme");
		// Click on 2. Dark Theme.
		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Dark Theme']"))
				.click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='RadioButton 2']")).click();
		  // Click on RadioButton 2 to select it.
		  driver.findElement(By.xpath("//android.widget.RadioButton[@text='RadioButton 1']")).click();
}
	}
