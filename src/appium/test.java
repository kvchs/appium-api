package appium;
//
//public class test {
//	
//	
//
//}

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class test {
	
	private static AndroidDriver driver;
	public static void main(String args[]) throws InterruptedException, MalformedURLException {
		File classpathRoot = new File(System.getProperty("user.dir"));//获取工程完整路径
		
		System.out.println(classpathRoot);
		File app = new File(classpathRoot, "apps/iBiliPlayer-bili.apk");
		
		System.out.println(app);
		if(!app.exists()){
			System.out.println("本次要安装的APK不存在");
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");//Samsung Galaxy S3
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("udid", "192.168.153.101:5555");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "tv.danmaku.bili");
		capabilities.setCapability("app-activity", "tv.danmaku.bili/.ui.splash.SplashActivity");
		
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("222222222");
		Thread.sleep(10000);
		
		int width=driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
//		driver.(width*4/5,height/2,width/2,height/2,1000);
		driver.quit();
		
	}

}