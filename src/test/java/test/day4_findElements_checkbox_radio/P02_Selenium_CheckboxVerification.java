package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P02_Selenium_CheckboxVerification {
    public static void main(String[] args) {
        //TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        // 1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // 3.Verify	“Success	–Check	box	is NOT checked”
        // message	is	NOTdisplayed.
        WebElement successcheckbox = driver.findElement(By.xpath("//input[@id = 'isAgeSelected']"));
        if(!successcheckbox.isSelected() && !driver.findElement(By.xpath("//div[@id = 'txtAge']")).isDisplayed()){
            System.out.println("Success Check box is NOT selected & Message is NOT displayed. Verification PASSED");
        }else{
            System.out.println("Success Check box is selected & Message is displayed. Verification FAILED");
        }

        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        driver.findElement(By.xpath("//input[@id = 'isAgeSelected']")).click();

        // 5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed.
        if(driver.findElement(By.xpath("//div[@id = 'txtAge']")).getText().equals("Success - Check box is checked")){
            System.out.println("Message is displayed. Verification PASSED");
        }else {
            System.out.println("Message is not displayed. Verification FAILED");
        }

        driver.close();




    }
}
