package test.practiceTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;

public class CheckboxVerification2 {
    public static void main(String[] args) {
        //TC	#3:	SeleniumEasy	Checkbox	Verification	–Section	2
        // 1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // 3.Verify	“Check	All”	button	text	is	“Check	All”
        WebElement checkAllbutton = driver.findElement(By.xpath("//input[@class = 'btn btn-primary']"));
        String checkAlltext = checkAllbutton.getAttribute("value");
        if(checkAlltext.equals("Check All")){
            System.out.println("Check all verification PASSED");
        }else{
            System.out.println("Check all verification FAILED");
        }


        // 4.Click	to	“Check	All”	button
        checkAllbutton.click();

        // 5.Verify	all	check	boxes	are	checked
        List<WebElement> listofCheckBoxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for(WebElement each : listofCheckBoxes){
            if(each.isSelected()){
                System.out.println("All checkboxes are checked. PASSED");
            }else{
                System.out.println("All checkboxes are not checked. FAILED");
            }
        }

        // 6.Verify	button	text	changed	to	“Uncheck All"
        String uncheck = driver.findElement(By.xpath("//input[@type = 'button']")).getAttribute("value");
        if(uncheck.equals("Uncheck All")){
            System.out.println("Button verification PASSED");
        }else{
            System.out.println("Button verification FAILED");
        }

       driver.close();



    }
}
