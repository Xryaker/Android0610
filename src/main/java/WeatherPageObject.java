import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WeatherPageObject extends BaseAndroidApp{

   static private By.ById temp= new By.ById("com.weather.forecast.weatherchannel:id/tvTemperature");

    public static String getTemp(){
        return driver.findElement(temp).getText();
    }
}
