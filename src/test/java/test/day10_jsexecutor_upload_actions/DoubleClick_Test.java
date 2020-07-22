package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DoubleClick_Test {
    /*
    TC	#16:	Double	ClickTest
    1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    2.Switch	to	iframe.
    3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
    4.Assert:	Text’s	“style”	attribute	value	contains "red"
     */



    @Test
    public void tc16_Double_click_test() throws InterruptedException {
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[@id = 'iframeResult']"));
        Driver.getDriver().switchTo().frame("iframeResult");

      Actions actions = new Actions(Driver.getDriver());
      WebElement texttoClick= Driver.getDriver().findElement(By.xpath("//p[@id = 'demo']"));

      actions.doubleClick(texttoClick).perform();

     Assert.assertTrue(texttoClick.getAttribute("style").contains("red"));
    }







}
