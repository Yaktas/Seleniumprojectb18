package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class Google_Shopping {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
    }

    @Test
    public void google_Shopping_avatar(){
     WebElement inputBox =  driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']"));
     inputBox.sendKeys("avatar t shirts"+ Keys.ENTER);

     driver.findElement(By.xpath("(//a[@class = 'q qs'])[2]")).click();

    }
}
