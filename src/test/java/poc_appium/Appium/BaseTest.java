package poc_appium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureAppium() {
		service = new AppiumServiceBuilder().withAppiumJS( new File("C://Users//salome.aristizabalg//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AppiumTesting");
		options.setApp("C://Users//salome.aristizabalg//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		
		
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction( WebElement element ) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
						"duration", 2000));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
