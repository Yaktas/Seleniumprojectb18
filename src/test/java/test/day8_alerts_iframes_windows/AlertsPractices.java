package test.day8_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test  (priority =  1)
    public void p1_information_alert_test(){
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[@onclick = 'jsAlert()']"));
        infoAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id = 'result']")).isDisplayed());
    }


    @Test (priority =  2)
    public void confirmation_alert_test(){
        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']"));
        confirmAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id = 'result']")).isDisplayed());

    }

    /*
    Click to “Click6.Verify “You entered:  hello” text is displayed
     */
    @Test (priority =  3)
    public void prompt_alert_test(){
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']"));
        infoAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id = 'result']")).isDisplayed());

    }


    @AfterMethod
    public void tearDown(){
            driver.close();
    }








}
