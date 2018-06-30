package appium;

import java.io.IOException;

public class AppiumServer {

	public void startServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
			Thread.sleep(10000);
		} catch (IOException  e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AppiumServer appiumServer = new AppiumServer();
		appiumServer.startServer();
		
		
		Thread.sleep(5);
		appiumServer.stopServer();
		
	}
}

// import java.io.IOException;
// import org.openqa.selenium.WebElement;
// import io.appium.java_client.android.AndroidDriver;
//
// public class AppiumServer {
// Process p;
// // Set path of your node.exe file.
// // Progra~1 represents Program Files folder.
// // String nodePath = "/usr/local/bin/node";
// String nodePath = "F:\\nodejs\\node.exe";
// // Set path of your appium.js file.
// // String appiumJSPath =
// "/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js";
// String appiumJSPath =
// "C:\\Users\\Administrator\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\Sappium.js";
// String cmd1 = nodePath + " " + appiumJSPath;
// String cmd = "appium";
// AndroidDriver<WebElement> driver;;
//
// // This method Is responsible for starting appium server.
// public void appiumStart() throws IOException, InterruptedException {
// // Execute command string to start appium server.
// p = Runtime.getRuntime().exec(cmd);
//
// // Provide wait time of 10 mins to start appium server properly.
// // If face any eÏrror(Could not start a new session...) then Increase
// // this time to 15 or 20 mins.
// Thread.sleep(20000);
// if (p != null) {
// System.out.println("Appium server Is started now.");
// }
// }
//
// // This method Is responsible for stopping appium server.
// public void appiumStop() throws IOException {
// System.out.println(p);
// if (p != null) {
// p.destroy();
// }
// System.out.println("Appium server Is stopped now.");
// }
//
// public void startAppium() throws IOException, InterruptedException {
// System.out.println("come here");
// appiumStop();
// appiumStart();
// }
// }