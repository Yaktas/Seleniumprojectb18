package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.day5_testNG_Intro.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Apple_FindElements {
    public static void main(String[] args) {
       // TC #03: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3.Click to all of the headers one by one
        // a.Mac, iPad, iPhone, Watch, TV, Music, Support
        // 4.Printout how many links on each pagewiththe titles of the pages
        // 5.Loop through all
        // 6.Print out how many link is missing textTOTAL
        // 7.Print out how many link has textTOTAL
        // 8.Print out how many total linkTOTAL

        int totalmissingtext = 0;
        int totaltext = 0;
        int totalLinks = 0;


        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']")).click();
       List<WebElement> listofMac =  driver.findElements(By.xpath("//body//a"));
       for(WebElement each : listofMac){
           if(each.getText().isEmpty()){
               totalmissingtext++;
           }else{
               totaltext++;
           }
       }
       totalLinks += listofMac.size();
        System.out.println( driver.getTitle() + " " +listofMac.size());
        driver.navigate().back();

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']")).click();
        List<WebElement> listofiPad =  driver.findElements(By.xpath("//body//a"));
        System.out.println( driver.getTitle() + " " +listofiPad.size());
        driver.navigate().back();

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();
        List<WebElement> listofiPhone =  driver.findElements(By.xpath("//body//a"));
        System.out.println( driver.getTitle() + " " +listofiPhone.size());
        driver.navigate().back();

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']")).click();
        List<WebElement> listofwatch =  driver.findElements(By.xpath("//body//a"));
        System.out.println( driver.getTitle() + " " +listofwatch.size());
        driver.navigate().back();

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tv']")).click();
        List<WebElement> listoftv =  driver.findElements(By.xpath("//body//a"));
        System.out.println( driver.getTitle() + " " +listoftv.size());
        driver.navigate().back();

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-music']")).click();
        List<WebElement> listofmusic =  driver.findElements(By.xpath("//body//a"));
        System.out.println( driver.getTitle() + " " +listofmusic.size());
        driver.navigate().back();

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-support']")).click();
        List<WebElement> listofsupport =  driver.findElements(By.xpath("//body//a"));
        System.out.println( driver.getTitle() + " " +listofsupport.size());

        System.out.println("******************************************");
        System.out.println("Links MISSING text: " +totalmissingtext);
        System.out.println("Links WITH text: " +totaltext);
        System.out.println("Total number of links: " +totalLinks);




        /*
        List<WebElement> Menu=  driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li//a")) ;
        int TotalMissingText=0;
        int TotalhasText=0;
        int TotalLink=0;
        for(int i=1 ; i< Menu.size()-2;i++){
            Menu.get(i).click();
            Thread.sleep(1000);
             driver.navigate().back();
             Menu= driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li//a")) ;
             List<WebElement> listOfElements=  driver.findElements(By.xpath("//body//a")) ;
             int countWithoutLinks=0;
             int countWithLinks=0;
             for (WebElement each:listOfElements) {
                 System.out.println(each.getText());
                 if (each.getText().isEmpty()){
                     countWithoutLinks++;
                 }else {
                     countWithLinks++;
                 }
             }
                            TotalMissingText+= countWithoutLinks;
                            TotalhasText+= countWithLinks;
                            TotalLink+=listOfElements.size();
             System.out.println(Menu.get(i).getText()+" link that does not have text " +countWithoutLinks);
             System.out.println(Menu.get(i).getText()+" link that does  have text "+countWithLinks);
             System.out.println(Menu.get(i).getText()+" total links on this page "+listOfElements.size());
         }
        System.out.println("Total Links does not have text "+TotalMissingText);
        System.out.println("Total Links does  have text "+TotalhasText);
        System.out.println("Total Links "+TotalLink);
         */
    }
}
