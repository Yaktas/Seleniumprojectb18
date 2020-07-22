package test.officeHours;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import test.day5_testNG_Intro.WebDriverFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaderPractice {

    private static Properties properties = new Properties();
    WebDriver driver;

    static {
        try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        String browser = properties.getProperty("browser");
        System.out.println(browser);
        System.out.println(properties.getProperty("url"));
    }


    @Test
    public void loginTest() throws Exception{
        String browser = getProperty("browser");
        String url = getProperty("url");
        driver = WebDriverFactory.getDriver(browser);
        driver.get(url);
        System.out.println(driver.getTitle());

        WebElement user = driver.findElement(By.name("_username"));
        String username = getProperty("username");
        user.sendKeys(username);

        WebElement pw = driver.findElement(By.name("_password"));
        String password = getProperty("password");
        pw.sendKeys(password, Keys.ENTER);


        Thread.sleep(5000);
        String expectedtitle = "Dashboard";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle, expectedtitle, "Page title is not correct");


    }


    @AfterMethod
    public void tearDown(){
       driver.quit();
    }



}
