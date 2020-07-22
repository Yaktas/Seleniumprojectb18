package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class IframePractice {
    /*
    1.Create a new class called: IframePractice
    2.Create new test and make set ups
    3.Go to: http://practice.cybertekschool.com/iframe
    4.Assert: “Your content goes here.” Text is displayed.
    5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test(priority =  1)
    public void p4_iframe(){
        WebElement iframe = driver.findElement(By.xpath("//body//iframe"));
        driver.switchTo().frame(iframe);

        Assert.assertTrue(driver.findElement(By.xpath("//body[@id = 'tinymce']/p")).isDisplayed());

        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
