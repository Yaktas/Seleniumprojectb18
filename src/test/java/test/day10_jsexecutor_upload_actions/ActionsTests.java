package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionsTests {


    @Test
    public void hover_over_test1(){
        Driver.getDriver().get("https://amazon.com");
        Actions actions = new Actions(Driver.getDriver());

       WebElement languageOptions = Driver.getDriver().findElement(By.id("icp-nav-flyout"));

        actions.moveToElement(languageOptions).perform();

    }


    @Test
    public void tc15_hover_test(){
        //1.Go	to	http://practice.cybertekschool.com/hovers
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(Driver.getDriver());

        //2.Hover	over	to	first	image
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img[@alt = 'User Avatar'])[1]"));
        actions.moveToElement(image1).perform();

        //3.Assert:
        //        a.“name:	user1”	is	displayed
        WebElement image1text = Driver.getDriver().findElement(By.xpath("(//div[@class = 'figcaption']//h5)[1]"));
        Assert.assertTrue(image1text.isDisplayed());

//        4.Hover	over	to	second	image
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img[@alt = 'User Avatar'])[2]"));
        actions.moveToElement(image2).perform();

//        5.Assert:
//        a.“name:	user2”	is	displayed
        WebElement image2text = Driver.getDriver().findElement(By.xpath("(//div[@class = 'figcaption']//h5)[2]"));
        Assert.assertTrue(image2text.isDisplayed());

//        6.Hover	over	to	third	image
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img[@alt = 'User Avatar'])[3]"));
        actions.moveToElement(image3).perform();

//        7.Confirm:
//        a.“name:	user3”	is	div
        WebElement image3text = Driver.getDriver().findElement(By.xpath("(//div[@class = 'figcaption']//h5)[3]"));
        Assert.assertTrue(image3text.isDisplayed());


    }




}
