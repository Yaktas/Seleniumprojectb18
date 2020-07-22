package test.practiceTasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class iFrame_and_Practice {
    WebDriver driver;

    @BeforeMethod
    public void  setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }



    @Test
    public void iFrame_practice() throws Exception{
        driver.get("http://demo.automationtesting.in/Frames.html");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@name = 'SingleFrame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//input[@type = 'text'])[1]")).sendKeys("Hello iFrame");
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        //dont forget to switch out of iframe
    }

    @Test
    public void Alerts_Practice(){
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void Alerts_Practice2(){
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}


