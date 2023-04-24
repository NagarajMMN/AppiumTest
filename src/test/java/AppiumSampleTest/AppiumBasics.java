package AppiumSampleTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {


    @Test
    public void AppiumTest() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("NewEmulator");
        options.setApp("C:\\Users\\nagar\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\ApiDemos-debug.apk");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:6000/wd/hub"), options);
    }
}
