package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseAndroidApp {
  public    static AndroidDriver driver;
    @BeforeClass
    public static void createAndroidCromeDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");//указываем версию Android
        caps.setCapability("app","C:\\Androin0610\\untitled\\Wether.apk");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//Сообщаем, что будет использоваться эмулятор
//        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.weather.forecast.weatherchannel.activities.SettingActivity");
        //caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.weather.forecast.weatherchannel");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1800);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
