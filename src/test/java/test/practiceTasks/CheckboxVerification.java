package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

public class CheckboxVerification {
    public static void main(String[] args) {
        //TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        // 1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // 3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
       WebElement successbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
       WebElement message = driver.findElement(By.xpath("//div[@id='txtAge']"));

       if(!message.isDisplayed()){
           System.out.println("Message verification PASSED");
       }else{
           System.out.println("Message verification FAILED");
       }


        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        successbox.click();

        // 5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed
        if(message.isDisplayed()){
            System.out.println("Message verification PASSED");
        }else{
            System.out.println("Message verification FAILED");
        }
    }
}
