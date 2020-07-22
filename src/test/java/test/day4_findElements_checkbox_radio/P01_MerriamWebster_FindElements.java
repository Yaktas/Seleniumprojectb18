package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P01_MerriamWebster_FindElements {
    /*
    TC #0: FINDELEMENTS
    1.Open Chrome browser
    2.Go to https://www.merriam-webster.com/
    3.Print out the texts of all links
    4.Print out how many link is missing text
    5.Print out how many link has text
    6.Print out how many total link
    USE XPATH
     */

    public static void main(String[] args) {
        //1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //Implict wait will upto given seconds
        //if page is loaded before time, it will continue
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2.Go to https://www.merriam-webster.com/
        driver.get("https://www.merriam-webster.com/");

        //3.Print out the texts of all links
        List<WebElement> listofLinks = driver.findElements(By.xpath("//body//a"));

        for(WebElement each : listofLinks){
            //System.out.println(each.getText());
        }

        //4.Print out how many link is missing text
        int withouttext=0;
        int withtext=0;
        for(WebElement each : listofLinks){
            if(each.getText().isEmpty()) {
                withouttext++;
            }else{
                withtext++;
            }
        }
        System.out.println("How many links do NOT have text: "+withouttext);


        //5.Print out how many link has text
        System.out.println("How many links have text: "+withtext);

        //6.Print out how many total link
        //System.out.println("Total number of links: "+(withouttext+withtext));
        System.out.println("Total number of links: "+listofLinks.size());

        driver.close();
    }
}
