package pages;
//We will store ALL login page related web elements and methods in this class

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "_username")
    public WebElement usernameInput;

    @FindBy(name = "_password")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class = 'alert alert-error']//div" )
    public WebElement errorMessage;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotYourPasswordLink;



    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}


