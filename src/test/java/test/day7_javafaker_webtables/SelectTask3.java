package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SelectTask3 {
    /*
    TC #3: Selecting date on dropdown and verifying
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Select “December 1st, 1921” and verify it is selected.
    Select year using: visible text
    Select month using : value attribute
    Select day using: index number
     */
    WebDriver driver;

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void task3_select_date_test() throws Exception{
        Select select = new Select(driver.findElement(By.id("year")));
        select.selectByVisibleText("1921");

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");

        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(0);

        Thread.sleep(3000);

        String actualyear = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualyear, "1921");

        String actualmonth = month.getFirstSelectedOption().getText();
        Assert.assertEquals(actualmonth, "December");

        String actualday = day.getFirstSelectedOption().getText();
        Assert.assertEquals(actualday, "1");


        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']")).click();
        Thread.sleep(3000);



    }
}
