package wetherobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WetherPageFactory {
    @FindBy(xpath = "//div[contains(@class,\"tabs-blockMain\")]")
    List<WebElement> elementList;
    public void print(){
        for(WebElement l:elementList){
            System.out.print(l.findElement(By.className("date")).getText() +" : max= ");
            System.out.print(l.findElement(By.className("max")).findElement(By.tagName("span")).getText()+" min= ");
            System.out.println(l.findElement(By.className("max")).findElement(By.tagName("span")).getText());
        }
    }
}
