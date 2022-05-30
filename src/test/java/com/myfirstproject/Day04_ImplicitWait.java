package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_ImplicitWait {
    @Test
    public void implicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //Implicit wait puts DYNAMIC WAIT MEANING wait will be depends on the page speed

        //implicit wait for 30 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com");

        }

    @Test
    public void threadSleep() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(30000);//Hard waits. Waits for30 seconds for no reason


    }
}
