package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class Add_RemoveElements {
    /*
    TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/add_remove_elements/
    3. Click to “Add Element” button
    4. Verify “Delete” button is displayed after clicking.
    5. Click to “Delete” button.
    6. Verify “Delete” button is NOT displayed after clicking.
    USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[contains(@onclick, 'addElement()')]")).click();


        boolean delete = driver.findElement(By.xpath("//button[@class='added-manually']")).isDisplayed();
        System.out.println("Delete button is displayed: "+delete);

        driver.findElement(By.xpath("//button[@class='added-manually']")).click();


        //how can we verify delete button is NOT displayed if it's gone off the page?
        boolean delete2 = driver.findElement(By.xpath("//button[@class='added-manually']")).isDisplayed();
        System.out.println("Delete button is NOT displayed now: "+delete2);



        //driver.close();




    }
}
