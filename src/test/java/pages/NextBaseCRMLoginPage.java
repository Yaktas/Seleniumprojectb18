package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NextBaseCRMLoginPage {

    public NextBaseCRMLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "USER_LOGIN")
    public WebElement usernameInputBox;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordInputBox;

    @FindBy(className =  "login-btn")
    public WebElement clickButton;

}
