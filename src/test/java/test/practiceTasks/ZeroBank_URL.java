package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class ZeroBank_URL {
    public static void main(String[] args) {
        //TC #4: Zero Bank URLverification
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://zero.webappsecurity.com/login.html
       driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Get attribute value of href from the “forgot your password”link
        String hrefattribute = driver.findElement(By.xpath("//a[.='Forgot your password ?']")).getAttribute("href");
        System.out.println("Attribute value of href: " +hrefattribute);

        // 4.Verify attribute value containsExpected: “/forgot-password.html
        if(hrefattribute.contains("/forgot-password.html")){
            System.out.println("Attribute verification PASSED");
        }else{
            System.out.println("Attribute verification FAILED");
        }
    }
}
