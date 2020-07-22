package test.day6_testng_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class Dropdowns_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }



    /*
TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Verify “Simple dropdown” default selected value is correct
    Expected: “Please select an option”
4.Verify“State selection” default selected value is correct
    Expected: “Select a State”
 */
    @Test
    public void test1_default_value_verification(){
        //3.Verify “Simple dropdown” default selected value is correct
        //        Expected: “Please select an option”

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'dropdown']")));
        String actualResult = simpleDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult, "Please select an option");


        //Verify“State selection” default selected value is correct
        //        Expected: “Select a State”

        Select stateSelection = new Select(driver.findElement(By.id("state")));
        String stateText = stateSelection.getFirstSelectedOption().getText();
        Assert.assertTrue(stateText.equals("Select a State"));

    }



    /*
    TC #2: Selecting state from State dropdown and verifying result 1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */
    @Test(priority = 2)
    public void state_dropdown_verification() throws Exception{
        Select stateSelection = new Select(driver.findElement(By.id("state")));

        stateSelection.selectByValue("IL");
        stateSelection.selectByVisibleText("Virginia");
        stateSelection.selectByIndex(5); // California
        String caliVerification = stateSelection.getFirstSelectedOption().getText();

        Assert.assertEquals(caliVerification, "California");

    }



    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.close();
    }


}
