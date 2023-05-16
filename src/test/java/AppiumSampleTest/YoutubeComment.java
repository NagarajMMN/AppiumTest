package AppiumSampleTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class YoutubeComment {
    public AndroidDriver driver;
    @BeforeClass
    public void YouBase() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Galaxy A30s");
        options.setUdid("RZ8MC09NLNK");
        options.setPlatformName("Android");
        options.setPlatformVersion("11");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.youtube");
        options.setAppActivity("com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
        options.setCapability("uiautomator2ServerInstallTimeout","6000");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    public void swipe(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));


    }

}
