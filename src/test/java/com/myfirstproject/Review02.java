package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Review02 {
    public static void main(String[] args) {
        /*
        Create a new class : Homework1
Using ChromeDriver, Go to facebook and verify if page title is “facebook”, If not, print the correct title.
Verify if the page URL contains facebook  if not, print the right url.
Then Navigate to https://www.walmart.com/
Verify if the walmart page title includes “Walmart.com”
Navigate back to facebook
Refresh the page
Maximize the window

         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        //Using ChromeDriver,
        WebDriver driver=new ChromeDriver();
        // Go to facebook
        driver.get("https://www.facebook.com");
        //verify if page title is “facebook”
        String actualFaceBookTitle=driver.getTitle();
        String expectedFaceBookTitle="facebook";
        if (actualFaceBookTitle.equals(expectedFaceBookTitle)){
            System.out.println("FaceBook Title PASSED");

        }else {
            System.out.println("FaceBookTitle==> FAILED");
            System.out.println("ActualFaceBookTitle: " +actualFaceBookTitle);
            System.out.println("ExpectedFaceBookTitle: " +expectedFaceBookTitle);
        }
        //Verify if the page URL contains facebook
        String actualUrl=driver.getCurrentUrl();

if (actualUrl.contains("facebook")){
    System.out.println(" URL contains \"facebook\" :Passed");
}else {
    System.out.println(" URL is not contains facebook:Failed");

}
// Navigate to https://www.walmart.com/
driver.navigate().to("https://www.walmart.com/");

//Verify if the walmart page title includes “Walmart.com”
String actualWalmartTitle=driver.getTitle();

if (actualWalmartTitle.contains("Walmart.com")){
    System.out.println("Walmart Page Title Passed");
}else{
    System.out.println("Walmart Page Title Failed");
    System.out.println("ActualTitle:"+actualWalmartTitle);
    System.out.println("Expected title is not contains\"Walmart.com\"" );
}
      //Navigate back to facebook
       driver.navigate().back();

        // Refresh the page
       driver.navigate().refresh();

        //Maximize the window
        driver.manage().window().maximize();

       //Close the window
       driver.close();
    }
}
