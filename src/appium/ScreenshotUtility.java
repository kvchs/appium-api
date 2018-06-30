//https://blog.csdn.net/fox990152806/article/details/79081622
//让新版appium支持ByName定位
/**
 * org.openqa.selenium.InvalidSelectorException: Locator Strategy 'name' is not supported for this session

1. 换其他定位方式，比如用xpath代替

2.不用换定位方式不用换之前脚本的方法来完成无缝升级appium版本的定位方式

修改源码解决问题，修改方法如下：


修改路径：

C:\Users\lili\AppData\Local\Programs\appium-desktop\resources\app\node_modules\appium\node_modules\appium-android-driver\build\lib

修改文件：driver.js

只需要修改其中一行即可
this.locatorStrategies = ['xpath', 'id', 'class name', 'accessibility id', '-android uiautomator','name'];--------再此行代码中添加上name

修改完成之后，保存文件，再次重启appium服务，就可以继续使用ByName定位


 * 
 * 
 * 
 * 
 */

package appium;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotUtility implements ITestListener {
	// This method will execute before starting of Test suite.
	public void onStart(ITestContext tr) {

	}

	// This method will execute, Once the Test suite is finished.
	public void onFinish(ITestContext tr) {

	}

	// This method will execute only when the test is pass.
	public void onTestSuccess(ITestResult tr) {
		captureScreenShot(tr, "pass");
	}

	// This method will execute only on the event of fail test.
	public void onTestFailure(ITestResult tr) {
		captureScreenShot(tr, "fail");
	}

	// This method will execute before the main test start (@Test)
	public void onTestStart(ITestResult tr) {

	}

	// This method will execute only if any of the main test(@Test) get skipped
	public void onTestSkipped(ITestResult tr) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
	}

	// Function to capture screenshot.
	public void captureScreenShot(ITestResult result, String status) {
		// AndroidDriver driver=ScreenshotOnPassFail.getDriver();
		String destDir = "";
		String passfailMethod = result.getMethod().getRealClass()
				.getSimpleName()
				+ "." + result.getMethod().getMethodName();
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) ScreenshotOnPassFail.driver)
				.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// If status = fail then set folder name "screenshots/Failures"
		if (status.equalsIgnoreCase("fail")) {
			destDir = "screenshots/Failures";
		}
		// If status = pass then set folder name "screenshots/Success"
		else if (status.equalsIgnoreCase("pass")) {
			destDir = "screenshots/Success";
		}

		// To create folder to store screenshots
		new File(destDir).mkdirs();
		// Set file name with combination of test class name + date time.
		String destFile = passfailMethod + " - "
				+ dateFormat.format(new Date()) + ".png";

		try {
			// Store file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
