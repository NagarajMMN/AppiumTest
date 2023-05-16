package AppiumSampleTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;


public class Youtube extends YoutubeComment {

        @Test
        public void OpenYoutube() throws MalformedURLException, InterruptedException {
                Thread.sleep(5000);
                driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();
                //driver.findElement(AppiumBy.id("com.google.android.youtube:id/search_edit_text")).sendKeys("Kolkata (Hooghly river) @Boarding Services@#$\n");
                driver.findElement(AppiumBy.id("com.google.android.youtube:id/search_edit_text"))
                        .sendKeys("What Is The MOST LIKED Reply On YouTube? (ANSWERED!) by Timeworks\n");
                driver.findElement(AppiumBy.id("com.google.android.youtube:id/text")).click();
                Thread.sleep(5000);
                driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Expand Mini Player\"]")).click();
                Thread.sleep(9000);
                try {
                        driver.findElement(AppiumBy.id("com.google.android.youtube:id/skip_ad_button_container")).click();
                        try {
                                driver.findElement(AppiumBy.accessibilityId("Close ad panel")).click();
                        } catch (Exception e) {
                                System.out.println("there is no bottom Ads");
                        }
                } catch (Exception e) {
                        System.out.println("There is no Ads");
                }
                Thread.sleep(5000);
                driver.findElement(AppiumBy.id("com.google.android.youtube:id/inset_controls_overlay_wrapper")).click();
                driver.findElement(AppiumBy.id("com.google.android.youtube:id/player_control_play_pause_replay_button_touch_area")).click();
                driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[4]")).click();
//                driver.findElement(AppiumBy.id("com.google.android.youtube:id/comment")).sendKeys("Nice view");
//                driver.findElement(AppiumBy.accessibilityId("Send comment")).click();
                Thread.sleep(2000);
                driver.findElement(AppiumBy.id("com.google.android.youtube:id/close_button")).click();
                driver.findElement(AppiumBy.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView[1]")).click();


                driver.findElement(AppiumBy.accessibilityId("View 114 total replies")).click();
                List<WebElement> replyy = driver.findElements(AppiumBy.accessibilityId("View 114 total replies"));
                int replyCount = replyy.size();
                System.out.println("count is " + replyCount);
                WebElement Drag = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Replies. \"]/android.view.ViewGroup"));
                ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) Drag).getId(),
                        "endX", 526,
                        "endY", 68
                ));

                int height = driver.manage().window().getSize().getHeight();
                int width = driver.manage().window().getSize().getWidth();
                System.out.println("height --> " + height + " width --> " + width);

                // Find the most liked comment
                List<Integer> numberList = new ArrayList<>();
                int biggestNumber = 0;
                int previousNumber = 0;
                boolean hasScrolledToEnd = false;
                String text= driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.view.ViewGroup[2]")).getText();
                System.out.println(text);

               while (!hasScrolledToEnd) {
                                Thread.sleep(500);
                                List<WebElement> commentsLike = driver.findElements(AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'Like this reply along with')]"));
                                int count = commentsLike.size();
                                System.out.println("count is " + count);
                                for (int i = 0; i < count; i++) {
                                        WebElement likeString = commentsLike.get(i);
                                        String likes = likeString.getAttribute("content-desc");
                                        int liken = Integer.parseInt(likeString.getAttribute("content-desc").replaceAll("[^0-9]", ""));
                                        String regex = "\\d+";
                                        String[] numbersStr = likes.split(regex);
                                        List<Float> numbers = new ArrayList<>();
                                        for (String numberStr : numbersStr) {
                                                try {
                                                        numbers.add(Float.parseFloat(numberStr));
                                                } catch (NumberFormatException e) {
                                                        // Ignore any non-numeric characters
                                                }
                                        }
                                        System.out.println( likes  + numbers);

                             if (liken > previousNumber) {
                                        biggestNumber = liken;
                                     System.out.println("previous number before  "+previousNumber);
                             }
                             previousNumber=liken;
                                        System.out.println("More No of Like :---> " + biggestNumber);

                             }

//                        try {
//                                        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingForward()"));
//                        }catch (Exception e){System.out.println("No more Scroll");}

               }Thread.sleep(10000);
               driver.quit();


        }
}

