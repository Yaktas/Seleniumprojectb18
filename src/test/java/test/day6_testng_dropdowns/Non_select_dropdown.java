package test.day6_testng_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class Non_select_dropdown {
    /*
    TC #5: Selecting value from non-select dropdown
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Click to non-select dropdown
    4.Select Facebook from dropdown
    5.Verify title is “Facebook -Log In or Sign Up”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test
    public void non_select_dropdown(){
   driver.findElement(By.id("dropdownMenuLink")).click();
   driver.findElement(By.xpath("//a[@href = 'https://www.facebook.com/']")).click();
        Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up" );

    }









    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.close();
    }
}
