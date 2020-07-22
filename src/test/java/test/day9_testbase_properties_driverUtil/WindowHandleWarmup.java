package test.day9_testbase_properties_driverUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import test.Base.TestBase;

import java.util.ArrayList;

public class WindowHandleWarmup extends TestBase {
    /*
    Create new test and make set ups
    3.Go to : https://www.amazon.com
    4.Copy paste the lines from below into your class
    5.Create a logic to switch to the tab where Etsy.com is open
    6.Assert: Title contains “Etsy”
     */

    @Test
    public void window_Handle_Warmup() throws InterruptedException {
        driver.get("http://amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        String google = driver.getWindowHandle();
/*
        Set<String> windowHandles = driver.getWindowHandles();

       for(String each : windowHandles){
           driver.switchTo().window(each);
           if(driver.getCurrentUrl().contains("etsy")){
               Assert.assertTrue(driver.getTitle().contains("Etsy"));
               //driver.get("http://etsy.com");
               break;

           }

       }

 */


        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        Thread.sleep(5000);
        driver.switchTo().window(tabs2.get(1)); // facebook
        Thread.sleep(5000);
        driver.switchTo().window(tabs2.get(2)); // etsy
        Thread.sleep(5000);
        driver.switchTo().window(tabs2.get(3)); //google
        Thread.sleep(5000);
        driver.switchTo().window(tabs2.get(0)); // amazon
        Thread.sleep(5000);






        }}
