package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Review01 {
    public static void main(String[] args) {
        /*
        Create a new class : Review1
Using ChromeDriver, Go to youtube and verify if page title is “youtube”, If not, print the correct title.
Verify if the page URL contains youtube if not, print the right url.
Then Navigate to https://www.amazon.com/
Navigate back to youtube
Refresh the page
Navigate forward to amazon
Maximize the window
Then verify if page title includes “Amazon”, If not, print the correct title.
Verify if the page URL is https://www.amazon.com/, if not print the correct url
         */


        //    Set Path
         System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        //    Create Chrome driver
        WebDriver driver = new ChromeDriver();
        //Go to youtube
        driver.get("https://www.youtube.com/");
        //Verify  if page title is  "youtube"
         String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        //Verify if expected equals actual
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Youtube Title Passed");
        }else{
            System.out.println("Youtube Title Failed");
            System.out.println("ActualTitle: " +actualTitle);
            System.out.println("ExpectedTitle:"+ expectedTitle);
        }
        //Then Navigate to https://www.amazon.com/
driver.navigate().to("https://www.amazon.com/");
        //Navigate back to youtube
        driver.navigate().back();
        //Refresh the page
        driver.navigate().refresh();
        //Navigate forward to amazon
        driver.navigate().forward();
        //Maximize the window
        driver.manage().window().maximize();
        //Then verify if page title includes “Amazon”, If not, print the correct title.
      String actualTitleAmazon=  driver.getTitle();

      if (actualTitleAmazon.contains("Amazon")){
      System.out.println("Amazon Page Title Includes \"Amazon\"==> Passed ");
     }else {
       System.out.println("Amazon Title is not includes \"Amazon\"==> Failed");
       System.out.println("Actual Title:" +actualTitleAmazon);
    ;

}
      //Verify if the page URL is https://www.amazon.com/, if not print the correct url
        String actualURLAmazon=driver.getCurrentUrl();
        String expectedURLAmazon="https://www.amazon.com/";
        if (actualURLAmazon.equals(expectedURLAmazon)){
            System.out.println("Amazon Url Passed");
        }else{
            System.out.println("Amazon Url Failed");
            System.out.println("ACTUAL : "+actualURLAmazon);
            System.out.println("EXPECTED : "+expectedURLAmazon);
        }
   driver.quit();
    }
}
