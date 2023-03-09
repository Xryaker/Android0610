package config;

import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    @BeforeClass
    public static void createAndroidCromeDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability("chromedriverExecutable", "C:\\driverandroidchrome\\chromedriver.exe");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");//указываем версию Android
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//Сообщаем, что будет использоваться эмулятор
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1800);
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }


}
//{
//  "platformVersion": "7.0",
//  "platformName": "Android",
//  "deviceName": "emulator-5554",
//  "appPackage": "com.weather.Weather",
//  "appActivity": "com.weather.Weather.app.SplashScreenActivity"
//}
