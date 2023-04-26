package AppiumSampleTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBase {

    public AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException
    {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("NewEmulator");
        options.setChromedriverExecutable("C:\\Users\\nagar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        options.setCapability("browserName","Chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
