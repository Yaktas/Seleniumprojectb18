package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_ {
    /*
    TC	#2:	Cybertek	verifications
    1.Open	Chrome	browser
    2.Go	to	https://practice.cybertekschool.com
    3.Verify	URL	containsExpected:	cybertekschool
    4.Verify	title:	Expected:	Practice
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cybertekschool.com");

        if(driver.getCurrentUrl().contains("cybertekschool")){
            System.out.println("URL verification PASSED!");
        }else{
            System.out.println("URL verification FAILED!!!");
        }

        if(driver.getTitle().equals("Practice")){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }




    }
}
