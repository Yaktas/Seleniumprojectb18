package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P02_FindElements_Apple {
    public static void main(String[] args) {
        //TC #02: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3.Click to iPhone
       // driver.findElement((By.xpath("//span[@class]"))).click();
        driver.findElement((By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"))).click();
        //driver.findElement((By.xpath("//a[@href='/iphone/']"))).click();


        // 4.Print out the texts of all links
       List<WebElement> listoflinks = driver.findElements(By.xpath("//body//a"));
        for(WebElement each : listoflinks){
           // System.out.println(each.getText());
        }

        // 5.Print out how many link is missing text
        int missingtext = 0;
        int hastext = 0;

        for(WebElement each : listoflinks){
            if(each.getText().isEmpty()){
                missingtext++;
            }else{
                hastext++;
            }
        }
        System.out.println("Is missing text: " +missingtext);

        // 6.Print out how many link has text
        System.out.println("Has text: "+hastext);

        // 7.Print out how many total link
        System.out.println("Total links: " +listoflinks.size());
    }
}
