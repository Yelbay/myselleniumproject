package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_ThreadSleep {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");
        //WAIT FOR 5 SECOND ==5000 MILLISECOND
        Thread.sleep(5000);//we add exception here over hover to sleep and add method signature

        driver.get("https://www.amazon.com/");
        //WAIT FOR 10 SECOND ==5000 MILLISECOND
        Thread.sleep(10000);
        driver.quit();
        /*
        *Thread.sleep is a Java Wait
        * It is not coming from selenium
        * It is a Hard Wait
        * It means driver will wait for 5 seconds no matter what.
        * If Driver do not need any wait ,it will still wait exatly 5 seconds
        * Testers should avoid using Thread.sleep cause it puts unnecessary waits
        * We will learn selenium implicit and explicit waits in the upcoming classes
        *
        * This wit throws acception so add exception to method signiture or use try catch
         */

    }
}
