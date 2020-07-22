package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    /*
    TC#4:	Google	search
    1-Open	a	chrome	browser
    2-Go	to:	https://google.com
    3-Write	“apple”	in	search	box
    4-Click	google	search	button
    5-Verify	title:Expected:	Title	should	start	with	“appl
     */

    public static void main(String[] args) {

        //1
        WebDriverManager.chromedriver().setup();

        //1
        WebDriver driver = new ChromeDriver();

        //2
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        //3 + 4
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

       // driver.findElement(By.name("q")).sendKeys("apple");
       // driver.findElement(By.name("btnK")).click();

        //5
        if(driver.getTitle().startsWith("apple")){
            System.out.println("Google search title verification PASSED");
        }else{
            System.out.println("Google search title verification FAILED");
        }





    }
}
