package AppiumSampleTest;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest {
    @Test
    public void ScrollDownUp() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //method1 scroll by google
       driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        //method2
       // ScrollToEndAction();
        Thread.sleep(4000);
    }
}
