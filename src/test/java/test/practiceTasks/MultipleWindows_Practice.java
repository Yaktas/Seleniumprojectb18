package test.practiceTasks;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.Base.TestBase;

import java.util.Set;

public class MultipleWindows_Practice extends TestBase {

    @Test
    public void multipleWindows(){

        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.findElement(By.linkText("Open New Seperate Windows")).click();
        driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
        Set<String> windows = driver.getWindowHandles();

        for(String eachwindow : windows){
            driver.switchTo().window(eachwindow);
            if(driver.getTitle().contains("Home")){
                driver.switchTo().window(eachwindow);
                Assert.assertTrue(true);
                break;
            }
        }
    }


}
