import config.BaseAndroidApp;
import org.junit.BeforeClass;
import org.junit.Test;
import settingsobjects.SettingWether;
import settingsobjects.enums.SpeddFormats;
import settingsobjects.enums.TempFormat;

public class TestWether extends BaseAndroidApp {

  @BeforeClass
  public static void bsetting(){
      SettingWether settingWether=new SettingWether(driver);
      settingWether.slectTempFormat(TempFormat.FARENGATE);
      settingWether.selectWindSpeed(SpeddFormats.KNOT);
      settingWether.selectNotifications(true);
      settingWether.confirm();
  }
    @Test
    public void test1()  {
        System.out.println("hello");

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
}
