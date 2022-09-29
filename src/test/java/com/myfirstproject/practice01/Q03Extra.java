package com.myfirstproject.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q03Extra {
WebDriver driver;
    // ...Exercise3...
    // go to url : https://www.techlistic.com/p/selenium-practice-form.html
    //fill the firstname
    //fill the lastname
    //check the gender
    //check the experience
    //fill the date
    //choose your profession -> Automation Tester
    //choose your tool -> Selenium Webdriver
    //choose your continent -> Antartica
    //choose your command  -> Browser Commands
    //click submit button
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        Thread.sleep(2000);
        //fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Janet");
driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bayle");
driver.findElement(By.xpath("//input[@id='sex-0']")).click();
driver.findElement(By.xpath("//input[@id='exp-0']")).click();
driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("15-03-2022");
driver.findElement(By.xpath("//input[@id='profession-1']")).click();
//choose your tool -> Selenium Webdriver
driver.findElement(By.xpath("//input[@id='tool-2']")).click();



        //choose your continent -> Antartica
        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Antartica");

        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("(//option[@style='margin: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;'])[8]")).click();

        Thread.sleep(5000);
    }
@After
    public void tearDown(){
        driver.close();
}
}
