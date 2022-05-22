package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {
        /*
        TEST CASE:
         Test if amazon contains “Registry” on the homepage
         */
        //Set Path How to write a simple setpath
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        //    Create chrome driver
        WebDriver driver=new ChromeDriver();
        //Maximise the window
        driver.manage().window().maximize();
        //Navigate to google homepage
        driver.get("https://www.amazon.com");
        //Test if amazon contains "Registry" on the homepage
        String pageSource=driver.getPageSource();
        System.out.println(pageSource);

        if(pageSource.contains("Registry")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.quit();
    }
}
