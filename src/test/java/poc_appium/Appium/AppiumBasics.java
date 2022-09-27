package poc_appium.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumBasics {

	@Test
	public void AppiumTest() {
		AppiumServiceBuilder service = new AppiumServiceBuilder();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AppiumTesting");
		options.setApp("C://Users//salome.aristizabalg//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		
		
		try {
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			driver.quit();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
