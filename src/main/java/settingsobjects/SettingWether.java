package settingsobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import settingsobjects.enums.SpeddFormats;
import settingsobjects.enums.TempFormat;

import java.util.List;

public class SettingWether {
    public SettingWether(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    private AndroidDriver androidDriver;
    String tempId = "com.weather.forecast.weatherchannel:id/tgTemperature_setting";
    String speedID = "com.weather.forecast.weatherchannel:id/iv_arrow_distance";
    String spedFormatID = "com.weather.forecast.weatherchannel:id/tv_wind_speed_format";
    String speedIDControlLIST = "com.weather.forecast.weatherchannel:id/md_contentRecyclerView";
    String notificationSettingsID = "com.weather.forecast.weatherchannel:id/tgNotifi_settings";
    String doneButtonID = "com.weather.forecast.weatherchannel:id/tvDone";

    public void slectTempFormat(TempFormat t) {
        if (!androidDriver.findElementById(tempId).getAttribute("checked").equals(t.toString())) {
            androidDriver.findElementById(tempId).click();
        }
    }

    public void selectTimeFormat(int i) {

    }

    public void selectWindSpeed(SpeddFormats speed) {
        if (!androidDriver.findElement(By.id(spedFormatID)).getText().equals(speed.getSpeed())) {
            androidDriver.findElement(By.id(speedID)).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MobileElement element = (MobileElement) androidDriver.findElement(By.id(speedIDControlLIST));
            List<MobileElement> listSped = element.findElementsByClassName("android.widget.LinearLayout");
            for (MobileElement l : listSped) {
                if (l.findElement(By.className("android.widget.TextView")).getText().equals(speed.getSpeed())) {
                    l.click();
                    break;
                }
            }
        }
    }

    public void selectNotifications(boolean b) {
        if (!androidDriver.findElementById(notificationSettingsID).getAttribute("checked").equals(String.valueOf(b))) {
            androidDriver.findElementById(notificationSettingsID).click();
        }

    }
    public void confirm(){
        androidDriver.findElement(By.id(doneButtonID)).click();
    }
}
