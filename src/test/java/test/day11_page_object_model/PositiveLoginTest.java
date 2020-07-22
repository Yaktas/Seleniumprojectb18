package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTest {

    LoginPage loginPage;

    @Test
    public void tc32_positive_login_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();

        loginPage.login(ConfigurationReader.getProperty("storemanager_username"), ConfigurationReader.getProperty("storemanager_password"));

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
