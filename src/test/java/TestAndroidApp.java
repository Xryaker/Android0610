import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestAndroidApp extends BaseAndroidApp {
    @BeforeClass
    public static void b() throws InterruptedException {
        driver.findElement(By.id("com.weather.forecast.weatherchannel:id/tvDone")).click();
        waitAds();
        try {
            driver.findElement(By.id("com.weather.forecast.weatherchannel:id/md_buttonDefaultNegative")).click();
        }catch (Exception ignore){};
        }

    private static void waitAds() {
        while(!driver.currentActivity().contains("gms.ads")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.navigate().back();
    }

    @Test
    public void test1() {
        System.out.println(WeatherPageObject.getTemp());
    }
}
