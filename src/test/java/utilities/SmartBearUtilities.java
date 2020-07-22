package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    public static void login(WebDriver driver){
        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }



    public static void verifyOrdering(WebDriver driver, String name){
       List<WebElement> listofNames = driver.findElements(By.xpath("//table[@class = 'SampleTable']//tr//td[2]"));


       for(WebElement each : listofNames){
           if(each.getText().equals(name)){
               Assert.assertTrue(true);
               return;
           }
       }

        Assert.fail("The name is not contained in the list. Verification failed");


    }



    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> listofNames = driver.findElements(By.xpath("//table[@class = 'SampleTable']//tr//td[2]"));
        List<WebElement> listofCities = driver.findElements(By.xpath("//table[@class = 'SampleTable']//tr//td[7]"));

        String names="";
        String cities="";


        for(int i = 0; i <listofNames.size(); i++){
            System.out.println("Name: " +listofNames.get(i).getText()+ ", City: "+listofCities.get(i).getText());
        }


    }



    public static void removeName(WebDriver driver, String name){
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));
        for (int i = 0; i < namesList.size(); i++) {
            if (namesList.get(i).getText().equals(name)) {
                List<WebElement> element = driver.findElements(By.xpath("//table[@class='SampleTable']//td[1]"));
                element.get(i).click();
            }
        }
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']")).click();
    }

}


