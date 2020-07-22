package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P04_CybertekCheckboxes {

    public static void main(String[] args) {
        //1.Go	to	http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // 2.Confirm	checkbox #1	is	NOT	selected by	default<input type="checkbox">
       WebElement checkbox1 =  driver.findElement(By.xpath("//input[@type = 'checkbox'][1]"));
       if(!checkbox1.isSelected()){
           System.out.println("Checkbox1 is not selected. Verification PASSED!");
       }else {
           System.out.println("Checkbox1 is selected. Verification FAILED!");
       }


        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.<input type="checkbox" checked="">
        WebElement checkbox2 =  driver.findElement(By.xpath("//input[@type = 'checkbox'][2]"));
        if(checkbox2.isSelected()){
            System.out.println("Checkbox2 is selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox2 is not selected. Verification FAILED!");
        }

        // 4.Click	checkbox	#1	to	select	it.
        driver.findElement(By.xpath("//input[@type = 'checkbox'][1]")).click();

        // 5.Click	checkbox	#2	to	deselect	it.
        driver.findElement(By.xpath("//input[@type = 'checkbox'][2]")).click();

        // 6.Confirm	checkbox	#1	is	SELECTED.
        WebElement checkbox11 =  driver.findElement(By.xpath("//input[@type = 'checkbox'][1]"));
        if(checkbox11.isSelected()){
            System.out.println("Checkbox1 is selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox1 is not selected. Verification FAILED!");
        }

        // 7.Confirm	checkbox	#2	is	NOT
        WebElement checkbox22 =  driver.findElement(By.xpath("//input[@type = 'checkbox'][2]"));
        if(!checkbox22.isSelected()){
            System.out.println("Checkbox2 is NOT selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox2 is selected. Verification FAILED!");
        }
    }
}
