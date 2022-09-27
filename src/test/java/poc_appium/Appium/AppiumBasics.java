package poc_appium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumBasics {

	@Test
	public void AppiumTest() {
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS( new File("C://Users//salome.aristizabalg//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("http://127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AppiumTesting");
		options.setApp("C://Users//salome.aristizabalg//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		
		
		try {
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			driver.quit();
			service.stop();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
