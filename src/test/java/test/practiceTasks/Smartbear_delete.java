package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;

public class Smartbear_delete {
    /*
    TC #9: SmartBear delete order
    1.Open browser and login to SmartBear
    2.Delete “Mark Smith” from the list
    3.Assert it is deleted from the list
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.login(driver);
    }


    @Test
    public void deleteOrder_Test() throws Exception{
        driver.findElement(By.xpath("//table[@class = 'SampleTable']//tr[3]//td")).click();
       driver.findElement(By.xpath("//input[@name = 'ctl00$MainContent$btnDelete']")).click();

        List<WebElement> list = driver.findElements(By.xpath("//table[@class = 'SampleTable']//tr//td[2]"));
        for(WebElement each : list){
            Assert.assertFalse(each.getText().contains("Mark Smith"));

        }
    }











}
