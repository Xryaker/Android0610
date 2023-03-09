import config.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import wetherobjects.WetherPageFactory;

public class TestWithFactory extends BaseClass {
    static WetherPageFactory wetherPageFactory;
    @BeforeClass
    public static void b(){
        driver.get("https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%B4%D0%BD%D0%B5%D0%BF%D1%80-303007131");
        wetherPageFactory= PageFactory.initElements(driver,WetherPageFactory.class);
    }
    @Test
    public void test(){
        wetherPageFactory.print();
    }
}
