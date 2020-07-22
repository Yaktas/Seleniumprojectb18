package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class HoverTest {
    /*
    TC	#16:	Hover	Test
    1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
    2.Drag	and	drop	the	small	circle	to	bigger	circle.
    //Actions.dragAndDrop(Sourcelocator, Destinationlocator)
    3.Assert:	-Text	in	big	circle	changedto:	“You	did	great!
     */

    @Test
    public void hover_Test(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement smallcircle = Driver.getDriver().findElement(By.xpath("//div[@id = 'draggable']"));
        WebElement bigcircle = Driver.getDriver().findElement(By.xpath("//div[@id = 'droptarget']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallcircle, bigcircle).perform();

        Assert.assertTrue(bigcircle.getText().equals("You did great!"));


    }
}
