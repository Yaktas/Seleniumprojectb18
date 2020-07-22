package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;

public class Apple_FindElements {
    public static void main(String[] args) {
        //1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3.Click to iPhone
        driver.findElement(By.xpath("//a[@class ='ac-gn-link ac-gn-link-iphone']")).click();

        // 4.Print out the texts of all links
        List<WebElement> listofLinks = driver.findElements(By.xpath("//body//a"));
        for(WebElement eachlink : listofLinks){
            System.out.println(eachlink.getText());
        }

        // 5.Print out how many link is missing text
        // 6.Print out how many link has text

        int missingText = 0;
        int hasText= 0;

        for(WebElement eachlink : listofLinks){
            if(eachlink.getText().isEmpty()){
                missingText++;
            }else{
                hasText++;
            }

        }
        System.out.println("Missing text: " +missingText);
        System.out.println("Has text: " +hasText);

        // 7.Print out how many total link

        System.out.println("Total links: " +listofLinks.size());
    }
}
