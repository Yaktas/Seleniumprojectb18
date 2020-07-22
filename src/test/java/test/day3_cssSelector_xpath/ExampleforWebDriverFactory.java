package test.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.day5_testNG_Intro.WebDriverFactory;

public class ExampleforWebDriverFactory {

    public static void main(String[] args) {
       WebDriver driver =  WebDriverFactory.getDriver("chrome");
       driver.get("https://www.google.com");

       driver.findElement(By.cssSelector("gg"));
    }
}
