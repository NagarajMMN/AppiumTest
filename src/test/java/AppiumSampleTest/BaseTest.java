package AppiumSampleTest;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("NewEmulator");
		options.setApp("C:\\Users\\nagar\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		
	}

	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}

	public void ScrollToEndAction()	{
		boolean canScrollMore;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", 100, "top", 100, "width", 200, "height", 200,
					"direction", "down",
					"percent", 3.0

			));
		}while(canScrollMore);
	}

	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),

				"direction", direction,
				"percent", 0.75
		));


	}


	@AfterClass
	public void TearDown() {

		driver.quit();
	}

}
