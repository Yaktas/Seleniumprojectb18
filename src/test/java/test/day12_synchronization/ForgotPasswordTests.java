package test.day12_synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ForgotPasswordTests {


    @Test
    public void tc35_title_url_verification() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginPage = new LoginPage();
        loginPage.forgotYourPasswordLink.click();
        Thread.sleep(3000);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Forgot Password");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa3.vytrack.com/user/reset-request");


    }



    @Test
    public void tc36_vytrack_forgot_password_errorMessage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("forgot_password_url"));

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        String randomUsername = "somethingsomething";
        forgotPasswordPage.idTextBox.sendKeys(randomUsername);

        forgotPasswordPage.requestButton.click();

        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());
        Assert.assertEquals(forgotPasswordPage.errorMessage.getText(), "There is no active user with username or email address " +"\"" +randomUsername +"\"" +".");




    }
}
