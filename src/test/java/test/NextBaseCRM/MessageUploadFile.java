package test.NextBaseCRM;

import org.testng.annotations.Test;
import pages.NextBaseCRMLoginPage;
import pages.PortalPage;
import utilities.Driver;

public class MessageUploadFile {


    /*
    User Story:
1. As a user, I should be able to send messages by clicking on Message tab under Active Stream.

Acceptance Criteria:
1. User should be able to click on upload files icon to
upload files and pictures from local disks, download from
external drive, select documents from bixtrix24, and create files to upload.
     */


    NextBaseCRMLoginPage nextBaseCRMLoginPage;
    PortalPage portalPage;




    @Test
    public void upload_files_message_tab(){
        Driver.getDriver().get("https://login.nextbasecrm.com/auth/?backurl=%2Fstream%2F");
        nextBaseCRMLoginPage.usernameInputBox.sendKeys("helpdesk35@cybertekschool.com");
        nextBaseCRMLoginPage.passwordInputBox.sendKeys("UserUser");
        nextBaseCRMLoginPage.clickButton.click();

        portalPage.MessageTab.click();
        portalPage.uploadFilesIcon.sendKeys("/Users/heenadhanani-afzal/Desktop/Screen Shot 2020-07-12 at 6.11.20 PM.png");
    }
}
