package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;

public class Smartbear_software_order {
    /*
    TC#3: Smartbear software order verification
    1.Open browser and login to Smartbear software
    2.Click on View all orders
    3.Verify Susan McLaren has order on date “01/05/2010”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
       // driver = WebDriverFactory.getDriver("chrome");
       // driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.login(driver);
    }


    @Test
    public void order_verification() throws Exception{

       WebElement susan = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        Assert.assertEquals(susan.getText(), "01/05/2010");
    }




    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
