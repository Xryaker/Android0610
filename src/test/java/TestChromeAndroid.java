import config.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import wetherobjects.WetherObject;

public class TestChromeAndroid extends BaseClass {
    static WetherObject wetherObject;

    @BeforeClass
    public static void b() {
        driver.get("https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%B4%D0%BD%D0%B5%D0%BF%D1%80-303007131");
        wetherObject = new WetherObject(driver);
    }

    @Test
    public void test1() {
        wetherObject.printTemp();
    }
}
