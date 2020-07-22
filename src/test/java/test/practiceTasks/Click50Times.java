package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;

public class Click50Times {

    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3. Click to “Add Element” button 50 times
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick = 'addElement()']"));

        for(int i = 1; i <=50; i++){
            addElementButton.click();
        }

        // 4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> deleteButton = driver.findElements(By.xpath("//button[@class = 'added-manually']"));
        if(deleteButton.size() == 50){
            System.out.println("50 buttons displayed. Verification PASSED");
        }else{
            System.out.println("50 buttons displayed. Verification FAILED");
        }

        // 5. Click to ALL “Delete” buttons to delete them.
        for(WebElement each : deleteButton){
            each.click();
        }


        // 6. Verify “Delete” button is NOT displayed after clicking.
        if(!driver.findElement(By.xpath("//body//a")).getText().equals("Delete")){
            System.out.println("Delete not displayed. PASSED");
        }else{
            System.out.println("Delete displayed. FAILED");
        }
        // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        // Hint: Need to use findElements method

    }
}

