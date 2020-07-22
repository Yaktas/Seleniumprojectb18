package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws Exception{
        //1- set up the web driver
        WebDriverManager.chromedriver().setup();

        //2 - create the instance of the chromedriver
        WebDriver driver = new ChromeDriver();

        // maximizes browser page
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //3- test if driver is working
        driver.get("https://www.google.com");



        //Broswer Navigations

        // this line adds 2000 milliseconds (2 seconds) of wait time
        Thread.sleep(2000);

        //this line will take user to the previous page
        driver.navigate().back();

        // this line is being added just to be able to see selenium movements
        Thread.sleep(2000);

        //this line will go to the next page
        driver.navigate().forward();

        Thread.sleep(2000);

        //this line will refresh the page
        driver.navigate().refresh();

        //this line will take you to page
        driver.navigate().to("https://www.facebook.com");

        //this line will return the title of the web page
        System.out.println("driver.getTitle()--> " +driver.getTitle());

        //this line will return the url of the web page
        System.out.println("driver.getCurrentUrl()--> " +driver.getCurrentUrl());

        //this line will return the page source of the web page
        //System.out.println(driver.getPageSource());

        //this line will close current browser tab
        driver.close();

        //this line will close all of the tabs and ends the session
        driver.quit();









    }
}
