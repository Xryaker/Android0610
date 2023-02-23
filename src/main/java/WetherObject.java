import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WetherObject {
    WebDriver driver;

    public WetherObject(WebDriver driver) {
        this.driver = driver;
    }

    public void printTemp() {
        for (int i = 1; i < 10; i++) {
            System.out.print(driver
                    .findElement(By.id("bd" + i)).findElement(By.className("date"))
                    .getText() +" : max= ");
            System.out.print(driver
                    .findElement(By.id("bd" + i)).findElement(By.className("max"))
                    .findElement(By.tagName("span"))
                    .getText() +" min= ");
            System.out.println(driver
                    .findElement(By.id("bd" + i)).findElement(By.className("min"))
                    .findElement(By.tagName("span"))
                    .getText());
        }
    }

}
