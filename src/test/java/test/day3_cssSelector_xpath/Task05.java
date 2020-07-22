package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task05 {
    /*
    TC #5: Basic authentication Zero Bank
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Enter username: username
    4.Enter password: password
    5.Click sign in button
    6.Verify username is displayed on the page
    7.Verify the title Zero –Account Summary
    8.Verify the link Account Summary’s href value contains: “account-summary”
    Print out results in validation formats
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.name("user_login")).sendKeys("username");
        driver.findElement(By.name("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        //driver.findElement(By.className("dropdown-toggle"));

        if(driver.getTitle().equals("Zero - Account Summary")){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }

        String att = driver.findElement(By.linkText("Account Summary")).getAttribute("href");

        if(att.contains("account-summary")){
            System.out.println("Attribute verification PASSED");
        }else{
            System.out.println("Attribute verification FAILED");

        }





    }
}
