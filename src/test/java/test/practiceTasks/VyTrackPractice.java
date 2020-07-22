package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.Base.TestBase;

import java.util.List;

public class VyTrackPractice extends TestBase {





    @Test
    public void vyTrackPracticE() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("user16");
        driver.findElement(By.name("_password")).sendKeys("UserUser123" + Keys.ENTER);
        driver.findElement(By.xpath("//span[@class='title title-level-1']")).click();
        //locating Vehicle Odometer option
        driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        Thread.sleep(2000);


       List<WebElement> list =  driver.findElements(By.xpath("//table[@class = 'grid table-hover table table-bordered table-condensed']//tr//td[3]"));

               for(WebElement each : list){
                   if(!each.getText().contains("May")){
                       System.out.println(each.getText());
                   }
               }



    }








}
