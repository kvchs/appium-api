package appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

    AndroidDriver<WebElement> driver;
    AppiumStartStop appiumServer;

    @BeforeTest
    public void setUp() throws Exception {

        appiumServer = new AppiumStartStop();
        appiumServer.appiumStart();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "c0875f69"); 
        capabilities.setCapability("browserName", "Android");       
        capabilities.setCapability("platformVersion", "4.3");
        capabilities.setCapability("platformName", "Android");  
        capabilities.setCapability("appPackage", "io.appium.android.apis"); // app包名
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos"); // app启动方法

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testAppearCorrect() throws InterruptedException {
        /**此处写你的测试脚本**/

        System.out.println("操作结束");
    }

    @AfterTest
    public void endUp() throws IOException {
        driver.quit();
        appiumServer.appiumStop();
    }
}