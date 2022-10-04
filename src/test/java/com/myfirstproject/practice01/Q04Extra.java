package com.myfirstproject.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04Extra {
    // ...Exercise4...
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Verify the result
    // Print the result
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

}
@Test
    public void test(){
     driver.get("https://testpages.herokuapp.com/styled/index.html");
     driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
    WebElement firstBox=driver.findElement(By.xpath("//input[@type='text'][1]"));
    WebElement secondBox= driver.findElement(By.xpath("//input[@type='text'][2]"));
    firstBox.sendKeys("20");
    secondBox.sendKeys("10");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
 String answer=driver.findElement(By.xpath("//span[@id='answer']")).getText();//getText bize String dondurur
Assert.assertEquals("30",answer);
}
@After
    public void tearDown(){
        driver.quit();
}
}
