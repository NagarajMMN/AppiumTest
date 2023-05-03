package AppiumSampleTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

	public AndroidDriver driver;
	//AppiumDriver driver;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("NewEmulator");   //this is for emulator congig
		//options.setDeviceName("SM-A307FN");  //this is for real device congig
//		options.setPlatformName("Android");
		//options.setDeviceName("SampleDevice");
		options.setChromedriverExecutable("C:\\Users\\nagar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		//options.setApp("C:\\Users\\nagar\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
		//options.setApp("C:\\Users\\nagar\\IdeaProjects\\AppiumTest\\src\\main\\resources\\saucelab.apk");
		options.setApp("C:\\Users\\nagar\\IdeaProjects\\AppiumTest\\src\\main\\resources\\General-Store.apk");
		//options.setCapability("uiautomator2ServerInstallTimeout","60000");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); //for appium above version 2
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);////for appium below version 2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}

	public void ScrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", 100, "top", 100, "width", 200, "height", 200,
					"direction", "down",
					"percent", 3.0

			));
		}while(canScrollMore);
	}

	public void swipeAction(WebElement ele,String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),

				"direction", direction,
				"percent", 0.75
		));


	}

	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}


	@AfterClass
	public void TearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
