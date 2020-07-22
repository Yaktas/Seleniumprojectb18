package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class ForgotPassword {
    public static void main(String[] args) {
        //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("hello@gmail.com");

        // 4.Click on Retrieve password
        driver.findElement(By.xpath("//button[@id = 'form_submit']")).click();

        // 5.Verify URL contains: Expected: “email_sent”
        if(driver.getCurrentUrl().contains("email_sent")){
            System.out.println("URL verification PASSED");
        }else{
            System.out.println("URL verification FAILED");
        }

        // 6.Verify textbox displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”

        String actualmessage=  driver.findElement(By.name("confirmation_message")).getText();
        if(actualmessage.equals("Your e-mail's been sent!")){
            System.out.println("Textbox verification PASSED");
        }else{
            System.out.println("Textbox verification FAILED");
        }



    }
}
