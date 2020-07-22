package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.Base.TestBase;
import utilities.Driver;

import java.util.List;

public class Practice_Cybertek extends TestBase {


    @Test
    public void checkbox_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Driver.getDriver().findElement(By.linkText("Checkboxes")).click();
        Driver.getDriver().findElement(By.xpath("(//input[@type ='checkbox'])[1]")).click();
        List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type ='checkbox']"));

        for(WebElement eachBox : checkboxes){
            Assert.assertTrue(eachBox.isSelected());
        }
    }

    @Test
    public void dynamic_loading_explicit_wait_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/2");
        Driver.getDriver().findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.xpath("//div[@id='loading']"))));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@id='finish']")).isDisplayed());
    }





}
