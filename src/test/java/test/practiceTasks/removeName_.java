package test.practiceTasks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import test.day5_testNG_Intro.WebDriverFactory;

public class removeName_ {
    /*
    TC #11: Create a method called removeName()
    1.Accepts two parameters: WebDriver, String name
    2.Method will remove the given name from the list of Smartbear
    3.Create a new TestNG test, and call your method.
    4.Assert that your method removed the given name
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.login(driver);
    }


    @Test
    public void removeName(){
        SmartBearUtilities.removeName(driver, "Mark Smith");
    }
}
