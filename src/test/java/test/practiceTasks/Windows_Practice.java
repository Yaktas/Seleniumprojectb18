package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class Windows_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://demo.automationtesting.in/Windows.html");
    }

    @Test
    public void windows_test() throws Exception{
        driver.findElement(By.xpath("//button[@class = 'btn btn-info']")).click();
        Thread.sleep(3000);

        for(String window : driver.getWindowHandles()){
            driver.switchTo().window(window);
            if(driver.getTitle().contains("Home")){
                Assert.assertTrue(true);
                break;
            }

        }






    }
}
