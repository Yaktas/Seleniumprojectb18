package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CybertekURLVerification {
    /*
    TC #3: PracticeCybertek/ForgotPassword URL verification
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/forgot_password
    3.Enter any email into input box
    4.Click on Retrieve password
    5.Verify URL contains: Expected: “email_sent”
    6.Verify textbox displayed the content as expected.
    Expected: “Your e-mail’s been sent!”
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.findElement(By.name("email")).sendKeys("dhananis420@aim.com");
        driver.findElement(By.id("form_submit")).click();

        String url = driver.getCurrentUrl();

       String actualmessage=  driver.findElement(By.name("confirmation_message")).getText();


        if(url.contains("email_sent") && actualmessage.equals("Your e-mail's been sent!")){
            System.out.println("Both Verifications PASSED");
        }else{
            System.out.println("Verifications FAILED");
        }

        if(driver.findElement(By.name("confirmation_message")).isDisplayed()){
            System.out.println("Message is displayed, verification PASSED");
        }else{
            System.out.println("Message is not displayed, verification FAILED");
        }




    }
}
