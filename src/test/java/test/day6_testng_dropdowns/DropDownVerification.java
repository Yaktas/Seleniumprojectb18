package test.day6_testng_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class DropDownVerification {
    /*
    TC #3: Selecting date on dropdown and verifying
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Select “December 1st, 1921” and verify it is selected.

     */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown_verification(){
        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1921");

        Select selectMonth = new Select(driver.findElement(By.id("month")));
        selectMonth.selectByValue("11");

        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectDay.selectByIndex(0);

        Assert.assertEquals(selectYear.getFirstSelectedOption().getText(), "1921");

        Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(), "December");

        Assert.assertEquals(selectDay.getFirstSelectedOption().getText(), "1");


    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
