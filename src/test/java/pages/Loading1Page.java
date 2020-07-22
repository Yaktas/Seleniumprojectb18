package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Loading1Page {

    public Loading1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@class = 'btn btn-primary'])[1]")
    public WebElement startButton;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@id = 'username']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id = 'pwd']")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@id = 'loading']")
    public WebElement loadingBar;

    @FindBy(xpath = "//div[@id = 'flash']")
    public WebElement invalidUsernameErrorMessage;
}
