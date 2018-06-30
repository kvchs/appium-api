package api.appium.documentation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CreateNewSession {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Simulator");
		//desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Test");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "E:\\appium\\apk\\ApiDemos.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		IOSDriver driver = new IOSDriver(url, desiredCapabilities);
		String sessionId = driver.getSessionId().toString();
		





	}

}
