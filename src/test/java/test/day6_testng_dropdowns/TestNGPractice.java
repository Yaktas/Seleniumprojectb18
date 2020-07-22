package test.day6_testng_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class is running...");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running...");
    }

    @Ignore
    @Test
    public void test1(){
        System.out.println("Test1 running...");
        String actualTitle = "Homepage";
        String expected = "Homepage";

        Assert.assertEquals(actualTitle, expected); // replaces if else statement, returns test result
    }


    @Test
    public void test2(){
        System.out.println("Test2 running...");
        String actualTitle = "Amazon prime";
        String expectedInTitle = "prime";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        //Assert.assertFalse(actualTitle.contains(expectedInTitle));
        System.out.println("Checking if this line is running!!!!!");

    }



    @AfterClass
    public void afterClass(){
        System.out.println("After class is running...");
    }




}
