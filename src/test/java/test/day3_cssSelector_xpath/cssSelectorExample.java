package test.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class cssSelectorExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        driver.findElement(By.cssSelector("input[name=field-keywords]")).sendKeys("pens" + Keys.ENTER);



        if(driver.getTitle().contains("pens")){
            System.out.println("Verification PASSED");
            driver.close();
        }else{
            System.out.println("Verification FAILED");
        }


    }
}
