package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToyzTestFun {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://toyzdistributor.com");


        driver.findElement(By.linkText("6.5 HoverBoard - Black")).click();



        driver.findElement(By.id("AddToCart")).click();

        Thread.sleep(3000);
       // driver.findElement(By.className("btn continue-shopping  btn-default mr-10")).click();
        driver.findElement(By.name("checkout")).click();



    }
}
