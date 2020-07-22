package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {
    /*TC #4: Zero Bank URLverification
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Get attribute value of href from the “forgot your password”link
    4.Verify attribute value containsExpected: “/forgot-password.html”

     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

       String att = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");

        if(att.contains("/forgot-password.html"))
        {
            System.out.println("Attribute verification PASSED");
            boolean result = driver.findElement(By.linkText("Forgot your password ?")).isDisplayed();
            System.out.println(result);
            driver.close();
        }else {
            System.out.println("Attribute verification FAILED");
        }


    }
}
