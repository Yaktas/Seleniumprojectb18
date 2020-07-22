package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {
        /*
        TC	#1:	Google	Title	Verification
        1.Open	Chrome	browser
        2.Go	to	https://www.google.com
        3.Verify	title:	Expected:	Google
         */

    public static void main(String[] args) {

        //Step 1

        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        //Step 2
        driver1.get("https://www.google.com");


        //Step 3
        String actualTitle = driver1.getTitle();
        String expectedTitle = "Google";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification PASSED!");
        }else{
            System.out.println("Google title verification FAILED!!!");
        }



    }
}
