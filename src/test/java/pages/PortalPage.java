package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PortalPage {

    /*
    public PortalPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

     */

    @FindBy(xpath = "//span[@id = 'feed-add-post-form-tab-message']//span")
    public WebElement MessageTab;

    @FindBy(xpath = "//span[@id = 'bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFilesIcon;

}
