package test.day6_testng_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;

public class Multiple_select_dropdown {

/*
TC #4: Selecting value from multiple select dropdown
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Select all the options from multiple select dropdown.
4.Print out all selected values.
5.Deselect all values
 */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void multiple_select_dropdown() throws Exception{
        Select select = new Select(driver.findElement(By.name("Languages")));

        for(int i = 0; i <= 5; i++){
            select.selectByIndex(i);
        }
        List<WebElement> list = select.getAllSelectedOptions();


       for(WebElement each: list){
           System.out.println(each.getText());

           select.deselectAll();


    }}

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
