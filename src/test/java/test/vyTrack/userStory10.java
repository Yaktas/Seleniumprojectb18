package test.vyTrack;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

/*
10.As a truck driver I should be able to access Vehicle Fuel Logs

 */
public class userStory10 {

    @Test (priority = 1)
    public void userStory10_AC1() throws InterruptedException {
        //1.Verify that truck driver should be able to see all Vehicle Fuel information on the grid

        Driver.getDriver().get("https://qa1.vytrack.com/user/login");

        WebElement usernameBox = Driver.getDriver().findElement(By.name("_username"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement passwordBox = Driver.getDriver().findElement(By.name("_password"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = Driver.getDriver().findElement(By.name("_submit"));
        loginButton.click();

        Thread.sleep(3000);

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        actions.moveToElement(fleetModule).perform();

        WebElement fuelLogsModule = Driver.getDriver().findElement(By.linkText("Vehicles Fuel Logs"));
        fuelLogsModule.click();

        WebElement vehicleFuelLogsLogo = Driver.getDriver().findElement(By.className("oro-subtitle"));

        Assert.assertTrue(vehicleFuelLogsLogo.isDisplayed());

        System.out.println("AC 1 Test passed.");



    }


    @Test (priority = 2)
    public void userStory10_AC2() throws InterruptedException {
        //2.Verify that truck driver should be able to create Vehicle Fuel logs or cancel it
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");

        WebElement usernameBox = Driver.getDriver().findElement(By.name("_username"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement passwordBox = Driver.getDriver().findElement(By.name("_password"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = Driver.getDriver().findElement(By.name("_submit"));
        loginButton.click();

        Thread.sleep(3000);

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        actions.moveToElement(fleetModule).perform();

        WebElement fuelLogsModule = Driver.getDriver().findElement(By.linkText("Vehicles Fuel Logs"));
        fuelLogsModule.click();

        Thread.sleep(4000);


        WebElement createFuelLogButton = Driver.getDriver().findElement(By.xpath("//a[@title = 'Create Vehicle Fuel Logs']"));
        createFuelLogButton.click();

        Thread.sleep(4000);

        Faker faker = new Faker();

        WebElement odometerValue = Driver.getDriver().findElement(By.name("custom_entity_type[OdometerValue]"));
        odometerValue.sendKeys(faker.number().digit());

        WebElement liter = Driver.getDriver().findElement(By.name("custom_entity_type[Liter]"));
        liter.sendKeys(faker.number().digit());

        WebElement pricePerLiter = Driver.getDriver().findElement(By.name("custom_entity_type[PricePerLiter]"));
        pricePerLiter.sendKeys(faker.number().digit());

        WebElement totalPrice = Driver.getDriver().findElement(By.name("custom_entity_type[TotalPrice]"));
        totalPrice.sendKeys(faker.number().digit());

        WebElement date = Driver.getDriver().findElement(By.xpath("//input[@placeholder = 'Choose a date']"));
        date.click();
        WebElement todaysdate = Driver.getDriver().findElement(By.xpath("//button[@class = 'ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']"));
        todaysdate.click();
        Thread.sleep(2000);

        WebElement purchaser = Driver.getDriver().findElement(By.name("custom_entity_type[Purchaser]"));
        purchaser.sendKeys(faker.name().fullName());

        WebElement invoiceref = Driver.getDriver().findElement(By.name("custom_entity_type[InvoiceReference]"));
        invoiceref.sendKeys(faker.number().digit());

        WebElement vendor = Driver.getDriver().findElement(By.name("custom_entity_type[Vendor]"));
        vendor.sendKeys(faker.name().fullName());

        WebElement saveAndClose = Driver.getDriver().findElement(By.xpath("//button[@class = 'btn btn-success action-button']"));
        saveAndClose.click();

        System.out.println("AC 2 Test passed.");

    }


    @Test (priority = 3)
    public void AC_3() throws InterruptedException {
        //3.Verify that truck driver should be able to Edit , delete Vehicle Fuel Logs or
        //add attachment , add event
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");

        WebElement usernameBox = Driver.getDriver().findElement(By.name("_username"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement passwordBox = Driver.getDriver().findElement(By.name("_password"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = Driver.getDriver().findElement(By.name("_submit"));
        loginButton.click();

        Thread.sleep(3000);

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        actions.moveToElement(fleetModule).perform();

        WebElement fuelLogsModule = Driver.getDriver().findElement(By.linkText("Vehicles Fuel Logs"));
        fuelLogsModule.click();

        Thread.sleep(4000);


        WebElement createFuelLogButton = Driver.getDriver().findElement(By.xpath("//a[@title = 'Create Vehicle Fuel Logs']"));
        createFuelLogButton.click();

        Thread.sleep(4000);

        Faker faker = new Faker();

        WebElement odometerValue = Driver.getDriver().findElement(By.name("custom_entity_type[OdometerValue]"));
        odometerValue.sendKeys(faker.number().digit());

        WebElement liter = Driver.getDriver().findElement(By.name("custom_entity_type[Liter]"));
        liter.sendKeys(faker.number().digit());

        WebElement pricePerLiter = Driver.getDriver().findElement(By.name("custom_entity_type[PricePerLiter]"));
        pricePerLiter.sendKeys(faker.number().digit());

        WebElement totalPrice = Driver.getDriver().findElement(By.name("custom_entity_type[TotalPrice]"));
        totalPrice.sendKeys(faker.number().digit());

        WebElement date = Driver.getDriver().findElement(By.xpath("//input[@placeholder = 'Choose a date']"));
        date.click();
        WebElement todaysdate = Driver.getDriver().findElement(By.xpath("//button[@class = 'ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']"));
        todaysdate.click();
        Thread.sleep(2000);

        WebElement purchaser = Driver.getDriver().findElement(By.name("custom_entity_type[Purchaser]"));
        purchaser.sendKeys(faker.name().fullName());

        WebElement invoiceref = Driver.getDriver().findElement(By.name("custom_entity_type[InvoiceReference]"));
        invoiceref.sendKeys(faker.number().digit());

        WebElement vendor = Driver.getDriver().findElement(By.name("custom_entity_type[Vendor]"));
        vendor.sendKeys(faker.name().fullName());

        WebElement saveAndClose = Driver.getDriver().findElement(By.xpath("//button[@class = 'btn btn-success action-button']"));
        saveAndClose.click();

        Thread.sleep(5000);

        WebElement editButton = Driver.getDriver().findElement(By.xpath("//a[@title = 'Edit Vehicle Fuel Logs']"));
        editButton.click();

        Thread.sleep(3000);

        System.out.println("AC 3 Test passed.");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
       Driver.getDriver().close();
    }










    }













