package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class xPath_Practice {
    /*
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/forgot_password
    3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
        f. “Powered byCybertek School” text
    4. Verify all WebElements are displayed.
     */

    public static void main(String[] args) {
       WebDriver driver =  WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //home button
        boolean home = driver.findElement(By.xpath("//a[@class='nav-link']")).isDisplayed();
        System.out.println("Home button is displayed: " +home);


        //forgot password
        boolean password = driver.findElement(By.xpath("//div[@class='example']")).isDisplayed();
        System.out.println("Forgot password is displayed: " +password);

        //email text
        boolean email = driver.findElement(By.xpath("//label[@for='email']")).isDisplayed();
        System.out.println("Email text is displayed: " +email);

        //email input box
        boolean emailinput = driver.findElement(By.xpath("//input[@type='text']")).isDisplayed();
        System.out.println("Email input box is displayed: " +emailinput);

        //“Retrieve password” button
        boolean retrivepassword = driver.findElement(By.xpath("//button[@id='form_submit']")).isDisplayed();
        System.out.println("Retrieve password is displayed: " +retrivepassword);

        //“Powered byCybertek School” text
        boolean poweredby = driver.findElement(By.xpath("//div[@style='text-align: center;']")).isDisplayed();
        System.out.println("Powered by text is displayed: " +poweredby);

        driver.close();
    }
}
