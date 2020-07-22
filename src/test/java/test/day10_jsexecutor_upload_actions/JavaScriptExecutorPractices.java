package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class JavaScriptExecutorPractices {



    @Test
    public void jsexecutorTest() throws InterruptedException {
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        WebElement cybertekschoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        //can scroll to the element you are looking for
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
        Thread.sleep(4000);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",cybertekschoolLink);



    }








}
