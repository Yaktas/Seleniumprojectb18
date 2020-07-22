package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cybertek_month_Dropdown {


    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test
    public void month_default_values_test(){
        String date2 = LocalDate.now().getMonth().name();
        date2 = date2.toLowerCase();

        Select select = new Select(driver.findElement(By.xpath("//select[@id = 'month']")));
        String option = select.getFirstSelectedOption().getText();
        option = option.toLowerCase();

        Assert.assertEquals(option, date2);
      //  Assert.assertTrue(option.equalsIgnoreCase(date2));
    }



    @Test
    public void cybertek_Month_dropdown(){
       List<WebElement> list =  driver.findElements(By.xpath("//select[@id = 'month']//option"));
       List<String> list2 = new ArrayList<>(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));



        for(WebElement each : list){
           Assert.assertTrue(list2.contains(each.getText()));
       }



    }

}
