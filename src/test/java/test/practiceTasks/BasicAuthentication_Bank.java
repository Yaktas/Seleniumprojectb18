package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class BasicAuthentication_Bank {
    public static void main(String[] args) {
        //TC #5: Basic authentication Zero Bank
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Enter username: username
        driver.findElement(By.xpath("//input[@id ='user_login']")).sendKeys("username");
        // 4.Enter password: password
        driver.findElement(By.xpath("//input[@id ='user_password']")).sendKeys("password");

        // 5.Click sign in button
        driver.findElement(By.xpath("//input[@value ='Sign in']")).click();

        // 6.Verify username is displayed on the page
        if(driver.findElement(By.xpath("(//a[@class = 'dropdown-toggle'])[2]")).getText().equals("username")){
            System.out.println("Username verification PASSED");
        }else {
            System.out.println("Username verification FAILED");
        }

        // 7.Verify the title Zero –Account Summary
        if(driver.getTitle().equals("Zero - Account Summary")){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }

        // 8.Verify the link Account Summary’s href value contains: “account-summary”
        if(driver.getCurrentUrl().contains("account-summary")){
            System.out.println("URL verification PASSED");
        }else{
            System.out.println("URL verification FAILED");
        }
        driver.close();

        // Print out results in validation formats
    }
}
