package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Checkbox {
    public static void main(String[] args) throws Exception {
//   TC	#3:	SeleniumEasy	Checkbox	Verification	–Section	2
//   1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//   2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");



//   3.Verify	“Check	All”	button	text	is	“Check	All”
        if(driver.findElement(By.xpath("//input[@id = 'check1']")).getAttribute("value").equals("Check All")){
            System.out.println("Check all button text verified. Verification PASSED");
        }else{
            System.out.println("Check all button text not verified. Verification FAILED");
        }



//   4.Click	to	“Check	All”	button
        driver.findElement(By.xpath("//input[@class = 'btn btn-primary']")).click();


//   5.Verify	all	check	boxes	are	checked
     List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@class = 'cb1-element']"));
     for(WebElement each : checkboxList){
         if(each.isSelected()){
             System.out.println("All checkboxes are checked. Verification PASSED");
         }else{
             System.out.println("All checkboxes are not checked. Verification FAILED");
         }
     }


//   6.Verify	button	text	changed	to	“Uncheck All"


        if(driver.findElement(By.xpath("//input[@class = 'btn btn-primary']")).getAttribute("value").equals("Uncheck All")){
            System.out.println("Button text changed. Verification PASSED");
        }else{
            System.out.println("Button text did not change. Verification FAILED");
        }


        driver.close();



    }}
