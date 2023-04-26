package RealDevice;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseFile {
    public AppiumDriver driver;

    @BeforeClass
    public void ConfigureApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","SM A307FN");
        cap.setCapability("udid","RZ8MC09NLNK");
        cap.setCapability("platformName","Android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("platformVersion","11");
        cap.setCapability("appPackage","io.appium.android.apis");
        cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
//        cap.setCapability("appWaitForLaunch",true);
//        cap.setCapability("forceAppLaunch", true);
       // cap.setCapability("fullReset",true);
        cap.setCapability("uiautomator2ServerInstallTimeout", "60000");


        URL url = new URL("http://127.0.0.1:4723");   //server running at port 6000
        driver = new AppiumDriver(url,cap);

    }

    @AfterClass
    public void CloseDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
