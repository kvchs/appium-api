//http://www.software-testing-tutorials-automation.com/2015/11/appium-how-to-swipe-vertical-and.html
//issue: swipe can not use
//https://blog.csdn.net/kbkaaa/article/details/78513383
//https://blog.csdn.net/weixin_40180628/article/details/79170053
//Appium的辅助类，主要针对手势操作，比如滑动、长按、拖动等。针对最新版本（5.0.4）已不支持swipe等方法，所以可以用TouchAction类来封装成新的swipe方法。
/**
 * 
 * [RemoteTestNG] detected TestNG version 6.11.0
五月 22, 2018 8:30:46 下午 org.openqa.selenium.remote.ProtocolHandshake createSession
信息: Detected dialect: OSS
FAILED: swipingHorizontal
java.lang.Error: Unresolved compilation problems: 
	The method swipe(int, int, int, int, int) is undefined for the type AppiumDriver
	The method swipe(int, int, int, int, int) is undefined for the type AppiumDriver

	at appium.DriverSwipe.swipingHorizontal(DriverSwipe.java:57)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.lang.reflect.Method.invoke(Unknown Source)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:108)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:661)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:869)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1193)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:126)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)
	at org.testng.TestRunner.privateRun(TestRunner.java:744)
	at org.testng.TestRunner.run(TestRunner.java:602)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:380)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:375)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)
	at org.testng.SuiteRunner.run(SuiteRunner.java:289)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1226)
	at org.testng.TestNG.runSuites(TestNG.java:1144)
	at org.testng.TestNG.run(TestNG.java:1115)
	at org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:114)
	at org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)
	at org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)

FAILED: swipingVertical
java.lang.Error: Unresolved compilation problems: 
	The method swipe(int, int, int, int, int) is undefined for the type AppiumDriver
	The method swipe(int, int, int, int, int) is undefined for the type AppiumDriver

	at appium.DriverSwipe.swipingVertical(DriverSwipe.java:86)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.lang.reflect.Method.invoke(Unknown Source)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:108)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:661)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:869)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1193)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:126)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)
	at org.testng.TestRunner.privateRun(TestRunner.java:744)
	at org.testng.TestRunner.run(TestRunner.java:602)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:380)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:375)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)
	at org.testng.SuiteRunner.run(SuiteRunner.java:289)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1226)
	at org.testng.TestNG.runSuites(TestNG.java:1144)
	at org.testng.TestNG.run(TestNG.java:1115)
	at org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:114)
	at org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)
	at org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)


===============================================
    Default test
    Tests run: 2, Failures: 2, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 2, Failures: 2, Skips: 0
===============================================

 */
package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DriverSwipe {
//	AndroidDriver driver;
	AppiumDriver driver;
	Dimension size;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZX1B32FFXF");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		capabilities.setCapability("appActivity", "com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	}

	@Test
	public void swipingHorizontal() throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.70);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);
		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;
		System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

		// Swipe from Right to Left.
		driver.swipe(startx, starty, endx, starty, 3000);
		Thread.sleep(2000);

		// Swipe from Left to Right.
		driver.swipe(endx, starty, startx, starty, 3000);
		Thread.sleep(2000);
		
		
	
	}

	@Test
	public void swipingVertical() throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find starty point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		// Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy
				+ " , startx = " + startx);

		// Swipe from Bottom to Top.
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		// Swipe from Top to Bottom.
		driver.swipe(startx, endy, startx, starty, 3000);
		Thread.sleep(2000);
		
		
	

		

		
	}

	@AfterTest
	public void End() {
		driver.quit();
	}

}