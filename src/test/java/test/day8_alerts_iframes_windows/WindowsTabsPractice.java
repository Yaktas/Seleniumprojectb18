package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

public class WindowsTabsPractice {
    /*
    1.Create	a	new	class	called:	WindowHandlePractice
    2.Create	new	test	and	make	set	ups
    3.Go	to	:	http://practice.cybertekschool.com/windows
    4.Assert:	Title	is	“Practice”
    5.Click	to:	“Click	Here”text
    6.Switch	to	new	Window.
    7.Assert:	Title	is	“New	Window"
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test(priority =  1)
    public void window_Handle_practice(){
        Assert.assertTrue(driver.getTitle().equals("Practice"));

        driver.findElement(By.linkText("Click Here")).click();

        for(String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            if(driver.getTitle().equals("New Window")){
                Assert.assertTrue(true);
            }
            break;
        }


    }
}
