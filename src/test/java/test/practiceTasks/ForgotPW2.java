package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

public class ForgotPW2 {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        // a. “Home” link
        WebElement home = driver.findElement(By.xpath("//a[@class = 'nav-link']"));

        // b. “Forgot password” header
        WebElement password = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        // c. “E-mail” textd. E-mail input box
        WebElement email = driver.findElement(By.xpath("//input[@name ='email']"));

        // e. “Retrieve password” button
        WebElement retrievePW = driver.findElement(By.xpath("//button[@id ='form_submit']"));

        // f. “Powered byCybertek School” text
        WebElement poweredBy = driver.findElement(By.xpath("//div[@style ='text-align: center;']"));

        // 4. Verify all WebElements are displayed.
        if(home.isDisplayed() && password.isDisplayed() && email.isDisplayed() && retrievePW.isDisplayed() && poweredBy.isDisplayed()){
            System.out.println("Verifiction PASSED");
        }else{
            System.out.println("Verification FAILED");
        }
    }
}
