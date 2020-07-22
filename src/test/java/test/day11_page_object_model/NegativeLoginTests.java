package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {

    LoginPage loginPage;

    @Ignore
    @Test
    public void negative_login_test() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        Driver.getDriver().findElement(By.name("_username")).sendKeys(ConfigurationReader.getProperty("storemanager_username"));
        Driver.getDriver().findElement(By.name("_password")).sendKeys("fjhkdfhdjf");
        Driver.getDriver().findElement(By.id("_submit")).click();


        //Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class = 'alert alert-error']//div")).getText().equals("Invalid user name or password."));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class = 'alert alert-error']//div")).isDisplayed(), "Error Message is NOT displayed");
    }

    @Test
    public void negative_login_test_with_page_object() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
       loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager_username"));
        loginPage.passwordInput.sendKeys("jhjhjhjkj");
        loginPage.submitButton.click();

        Thread.sleep(3000);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), "Invalid user name or password.");
    }


    @Test
    public void tc31_wrong_username_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();

        loginPage.login("something", ConfigurationReader.getProperty("storemanager_password"));

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());


    }

    /*
    TC#32 : Vytrack positive login testàSales Manager
    1. Go to https://qa3.vytrack.com
    2. Enter correct username
    3. Enter correct password
    4. Verify title changed
    Expected: “Dashboard”
     */






}
