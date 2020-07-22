package test.practiceTasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class Cybertek_Registration_Form {
    /*
    TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/registration_form
    3.Enter first name
    4.Enter last name
    5.Enter username
    6.Enter email address
    7.Enter password
    8.Enter phone number
    9.Select a gender from radio buttons
    10.Enter date of birth
    11.Select Department/Office
    12.Select Job Title
    13.Select programming language from checkboxes
    14.Clickto sign up button
    15.Verify success message “You’ve successfully completed registration.”is displayed.
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void cybertekReg() throws Exception{
        driver.get("http://practice.cybertekschool.com/registration_form");
        Faker faker = new Faker();

       WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
       firstName.sendKeys(faker.name().firstName());

       WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("fadkfdnjfnaiefa");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("293-444-3333");


        driver.findElement(By.xpath("//input[@value='female']")).click();

        WebElement birthday = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys("01/01/2020");

        Select select = new Select(driver.findElement(By.name("department")));
        select.selectByVisibleText("MCR");

        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();



        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        WebElement successMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']/h4/following-sibling::p"));


        Assert.assertTrue(successMessage.isDisplayed());


    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

