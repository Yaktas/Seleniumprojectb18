package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Smartbear_Software_link_verification {
    /*
    TC #1: Smartbear software link verification
    1.Open browser
    2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3.Enter username: “Tester”
    4.Enter password: “test”
    5.Click to Login button
    6.Print out count of all the links on landing page
    7.Print out each link text on this page
     */

    WebDriver driver;

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtilities.login(driver);

    }



    @Test
    public void p1_smartbear_test_verification(){
        List<WebElement> linkOnPage = driver.findElements(By.xpath("//body//a"));
        System.out.println("Count of all links on landing page: " +linkOnPage.size());

        Assert.assertEquals(linkOnPage.size(), 6); // extra step

        for(WebElement each : linkOnPage){
            System.out.println(each.getText());
        }
    }

    /*
    TC#2: Smartbearsoftware order placing
    6.Click on Order
    7.Select familyAlbum from product, set quantity to 2
    8.Click to “Calculate” button
    9.Fill address Info with JavaFaker
    •Generate: name, street, city, state, zip code
    10.Click on “visa” radio button
    11.Generate card number using JavaFaker
    12.Click on “Process”
    13.Verify success message “New order has been successfully added.
     */

    @Test
    public void p2_smartbear_order_placing() throws Exception{

        driver.findElement(By.xpath("//a[@href = 'Process.aspx']")).click();
        Select productName = new Select(driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")));
        productName.selectByVisibleText("FamilyAlbum");

        WebElement quantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantity.sendKeys(Keys.BACK_SPACE);
       // quantity.clear();
        quantity.sendKeys("2");

        driver.findElement(By.xpath("//input[@value = 'Calculate']")).click();

        Faker faker = new Faker();
        WebElement name = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        name.sendKeys(faker.name().fullName());

        WebElement street = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys(faker.address().streetAddress());

        WebElement city = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3"));
        city.sendKeys(faker.address().cityName());

        WebElement state = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
        state.sendKeys(faker.address().state());

        WebElement zip = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
        zip.sendKeys(faker.address().zipCode().replaceAll("-", ""));

        driver.findElement(By.xpath("//input[@value = 'Visa']")).click();

        WebElement ccNum = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox6']"));
        ccNum.sendKeys(faker.finance().creditCard().replaceAll("-", ""));

        WebElement expire = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
        expire.sendKeys("09/22");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();




        Assert.assertEquals("New order has been successfully added.",driver.findElement(By.xpath("//strong")).getText() );


    }
}
