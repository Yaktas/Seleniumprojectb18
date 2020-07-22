package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBear_Verfication {
    /*
    TC#5:	Basic	login	authentication
    1-Open	a	chrome	browser
    2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3-Verify	title	equals:
    Expected:	Web	Orders	Login
    4-Enter	username:	Tester
    5-Enter	password:	test
    6-Click	“Sign	In”	button
    7-Verify	titleequals:Expected:	Web	Orders

     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        if(driver.getTitle().equals("Web Orders Login")){
            System.out.println("Home page title verification PASSED");
        }else{
            System.out.println("Home page title verification FAILED");
        }

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");

        //enter user name ^^^

        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        //enter password ^^

        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        if(driver.getTitle().equals("Web Orders")){
            System.out.println("Landing page title verification PASSED");
        }else{
            System.out.println("Landing page title verification FAILED");
        }



    }
}
