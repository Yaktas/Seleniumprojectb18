package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;

public class Apple_FindElem2  {
    public static void main(String[] args) throws Exception {
        //1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3.Click to all of the headers one by one
        List<WebElement> headers =driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

        for (int i=1;i<8;i++) {
            headers.get(i).click();
            Thread.sleep(2000);

            // 4.Printout how many links on each pagewiththe titles of the pages
            List<WebElement> numofLinks = driver.findElements(By.xpath("//body//a"));
            System.out.println("Number of links on page: " +numofLinks.size() +" Title of the page: " +driver.getTitle());

        // 5.Loop through all

        // 6.Print out how many link is missing textTOTAL
            // 7.Print out how many link has textTOTAL
            // 8.Print out how many total linkTOTAL

            int missingText = 0;
            int hasText= 0;
            int totaltext = 0;

            for(WebElement each : numofLinks){
                if(each.getText().isEmpty()){
                    missingText++;
                }else{
                    hasText++;
                }
            }
            driver.navigate().back();
            headers =driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

            System.out.println("Links missing text: "+missingText);
            System.out.println("links with text: " +hasText);
            System.out.println("Total links: " +numofLinks.size());


    }
}}
