package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class Checkboxes {
    public static void main(String[] args) {
        //Practice:	Cybertek	Checkboxes
        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
        if(!driver.findElement(By.xpath("//input[@type = 'checkbox'][1]")).isSelected()){
            System.out.println("Checkbox 1 is NOT selected. PASSED");
        }else{
            System.out.println("Checkbox 1 is selected. FAILED");
        }

        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.
        if(driver.findElement(By.xpath("//input[@type = 'checkbox'][2]")).isSelected()){
            System.out.println("Checkbox 2 is selected. PASSED");
        }else{
            System.out.println("Checkbox 2 is NOT selected. FAILED");
        }

        // 4.Click	checkbox	#1	to	select	it.
        driver.findElement(By.xpath("//input[@type = 'checkbox'][1]")).click();

        // 5.Click	checkbox	#2	to	deselect	it.
        driver.findElement(By.xpath("//input[@type = 'checkbox'][2]")).click();

        // 6.Confirm	checkbox	#1	is	SELECTED.
        if(driver.findElement(By.xpath("//input[@type = 'checkbox'][1]")).isSelected()){
            System.out.println("Checkbox 1 is selected. PASSED");
        }else{
            System.out.println("Checkbox 1 is NOT selected. FAILED");
        }

        // 7.Confirm	checkbox	#2	is	NOT	selected
        if(!driver.findElement(By.xpath("//input[@type = 'checkbox'][2]")).isSelected()){
            System.out.println("Checkbox 2 is NOT selected. PASSED");
        }else{
            System.out.println("Checkbox 2 is selected. FAILED");
        }
    }
}
