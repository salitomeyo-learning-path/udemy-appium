package poc_appium.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void ScrollDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//Use where you know the element you want to scroll to
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
	
		scrollToEndAction();
	}
}
