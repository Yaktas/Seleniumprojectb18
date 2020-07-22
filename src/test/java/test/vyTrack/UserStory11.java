package test.vyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class UserStory11 {


    @Test (priority = 1)
    public void AC_1() throws Exception{
        //1.Verify that authorized user should be able to access and see all Vehicle service log
        //(Note: authorized:Truck driver, admin)

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

        Thread.sleep(3000);

        WebElement ServiceLogsModule = Driver.getDriver().findElement(By.xpath("(//span[@class = 'title title-level-2'])[6]"));
        ServiceLogsModule.click();

        Thread.sleep(4000);

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h1[@class = 'oro-subtitle']")).isDisplayed());

        System.out.println("AC 1 Test passed.");

    }



    @Test (priority = 2)
    public void AC_2() throws Exception{
        //2.Verify that non authorized user should Not be able to access Vehicle service log (non authorize:
        //Store manager, sales manager )"

        Driver.getDriver().get("https://qa1.vytrack.com/user/login");

        WebElement usernameBox = Driver.getDriver().findElement(By.name("_username"));
        usernameBox.sendKeys("storemanager61");

        WebElement passwordBox = Driver.getDriver().findElement(By.name("_password"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginButton = Driver.getDriver().findElement(By.name("_submit"));
        loginButton.click();

        Thread.sleep(3000);

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("(//span[@class = 'title title-level-1'])[2]"));

        actions.moveToElement(fleetModule).perform();

        WebElement fuelLogsModule = Driver.getDriver().findElement(By.xpath("//a[@href = 'entity/Extend_Entity_VehicleServicesLogs']//span"));
        fuelLogsModule.click();

        Thread.sleep(4000);

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class = 'alert alert-error fade in top-messages '])[2]")).isDisplayed());

        System.out.println("AC 2 Test passed.");

    }


}
