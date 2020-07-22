package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;

public class Add_RemoveElements {
    public static void main(String[] args) {
        /*
        TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification


        6. Verify “Delete” button is NOT displayed after clicking.
        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        Hint: Need to use findElements method
         */

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button 50 times

        for(int i = 1; i <= 50; i++){
            driver.findElement(By.xpath("//button[@onclick = 'addElement()']")).click();
        }

        //4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> deleteList= driver.findElements(By.xpath("//button[@class='added-manually']"));

        if(deleteList.size() == 50){
            System.out.println("Delete button verification PASSED");
        }else {
            System.out.println("Delete button verification FAILED");
        }

        //        5. Click to ALL “Delete” buttons to delete them.
        /*
        for(int i = 0; i < deleteList.size(); i++){
                deleteList.get(i).click();
        }

         */

        for(WebElement each :  deleteList){
            each.click();
        }


        // 6. Verify "Delete" button is NOT displayed after clicking.
        WebElement body=driver.findElement(By.xpath("//body//a"));
        if (!body.getText().contains("delete")) {
            System.out.println("Delete button is NOT displayed after clicking. Verification PASSED.");
        } else {
            System.out.println("Delete button is displayed after clicking. Verification FAILED.");
        }

        /*
        try {
        if (!deleteButton.isDisplayed()){
        System.out.println("Delete button is NOT displayed after clicking. PASS!");
        }else{
        System.out.println("Delete button is displayed after clicking. FAILED!");
         }
         }catch (StaleElementReferenceException exception){
         System.out.println("StaleElementException has been thrown.");
         System.out.println("It means element has been completely deleted from the HTML.");
         System.out.println("Delete button is not displayed. Verification PASSED!");
          }   }

         */


        driver.close();













    }
}
