package test.practiceTasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.Set;

public class TeamPractice  {


    @Test
    public void practiceTask(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles = driver.getWindowHandles();

        for(String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }

    }
}
