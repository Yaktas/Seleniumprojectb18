package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import test.day5_testNG_Intro.WebDriverFactory;

public class Smartbear_edit {
    /*
    TC #10: SmartBear edit order
    1.Open browser and login to SmartBear
    2.Click to edit button from the right for “Steve Johns”
    3.Change name to “Michael Jordan”
    4.Click Update
    5.Assert “Michael Jordan” is in the list
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.login(driver);
    }

    @Test
    public void micheal_Jordan_test() throws Exception{
        driver.findElement(By.xpath("(//input[@src = 'App_Themes/Default/images/button_edit.gif'])[3]")).click();
        WebElement name = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        name.clear();
        name.sendKeys("Michael Jordan");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        Thread.sleep(2000);


        SmartBearUtilities.verifyOrdering(driver, "Michael Jordan");

    }
}
