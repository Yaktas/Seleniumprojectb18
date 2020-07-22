package test.day12_synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractices {


    @Test
    public void tc40_dynamic_title_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));


        Loading7Page loading7Page = new Loading7Page();

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());
        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());


    }


    @Test
    public void tc41_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        Loading1Page loading1Page = new Loading1Page();

        loading1Page.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        //wait.until(ExpectedConditions.visibilityOf(loading1Page.userNameInput));
        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingBar));


        Assert.assertTrue(loading1Page.userNameInput.isDisplayed());

        loading1Page.userNameInput.sendKeys("tomsmith");

        loading1Page.passwordInput.sendKeys("incorrectpassword");

        loading1Page.submitButton.click();

        Assert.assertTrue(loading1Page.invalidUsernameErrorMessage.isDisplayed());


    }
}
