package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) {
        /*
        	    1.Create a new class: VerifyTitleTest
	            2.Navigate to google homepage
	            3.Verify if google title is “Google”
         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        // System.setProperty("webdriver.chrome.driver","./drivers.chromedriver.exe");windows

        WebDriver driver=new ChromeDriver();

        //Maximise the window
        driver.manage().window().maximize();

        //Navigate to google homepage
        driver.get("https://www.google.com");

        //Verify if  google title is"Google"
     String actualTitle=driver.getTitle();
     String expectedTitle="Google";
     //Verify if expected equals actual
        if(actualTitle.equals((expectedTitle))){
            System.out.println("PASS");
//            System.out.println("Expected : "+expectedTitle);
//            System.out.println("Actual :" +actualTitle);
        }else{
            System.out.println("FAILED");
            System.out.println("Expected :" +expectedTitle);
            System.out.println("Actual :"+actualTitle);
        }
        driver.quit();




    }
}
