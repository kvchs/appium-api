package appium;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleAlert {
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
	public void okOnAlert() {
		// Scroll till element which contains "App" text.
//		driver.scrollTo("App");
//		driver.switchTo("App")
		// Click on App.
		driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
		// Scroll till element which contains "Alert Dialogs" text.
//		driver.scrollTo("Alert Dialogs");
		// Click on Alert Dialogs.
		driver.findElement(By.xpath("//android.widget.TextView[@text='Alert Dialogs']")).click();
		// Click on "OK Cancel dialog with a message" button.
		driver.findElement(By.xpath("//android.widget.Button[@text='OK Cancel dialog with a message']")).click();
		// Get the text from alert dialog.
		String result = driver.findElementById("android:id/alertTitle")
				.getText();
		System.out.println("Alert text Is -> " + result);
		// Click on OK button of alert dialog.
		driver.findElement(By.id("android:id/button1")).click();
		// Click on Cancel button of alert dialog.
		// driver.findElement(By.name("Cancel")).click();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}
