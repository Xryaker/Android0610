import config.BaseYoutube;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class YoutubeTEST extends BaseYoutube {
    @Test
    public void test1() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();
        driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("Ukraine");
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER);
        Set<String> stringSet=new TreeSet<>();
        int i = 0;
        while (i < 5) {
            List<MobileElement> list = driver.findElements(By.className("android.view.ViewGroup"));
            for (MobileElement l : list) {
                try {
                   // System.out.println(l.getAttribute("content-desc"));
                    if(l.getAttribute("content-desc")!=null){
                        stringSet.add(l.getAttribute("content-desc"));
                    }
                } catch (Exception ignore) {
                }
                ;
            }

            i++;
            ScrollOneElement();
        }
        for(String l:stringSet){
            System.out.println(l);
        }
    }

    private MobileElement Menu(String name) {
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.FrameLayout\"), \"" + name + "\")"));
    }

    private void ScrollOneElement() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"));
    }
}
