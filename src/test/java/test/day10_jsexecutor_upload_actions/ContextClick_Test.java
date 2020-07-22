package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ContextClick_Test {
    /*
    TC	#17:	Context	Click	–HOMEWORK
    1.Go	to	https://the-internet.herokuapp.com/context_menu
    2.Right	click	to	the	box.
    actions.contextClick(elementLocator).perform();
    3.Alert	will	open.
    4.Accept	alertNo	assertion	needed	for	this	practice
     */


    @Test
    public void context_click_test(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(Driver.getDriver());

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }


}

