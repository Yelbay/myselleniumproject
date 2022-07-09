package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Review03  {
     protected static WebDriver driver;

    @Before

    public  void setUp() {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

        @Test
        public void findNutella() throws InterruptedException {
            driver.get("https://www.amazon.com");

            WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            searchBox.sendKeys("Nutella");
            searchBox.submit();

           WebElement bestNutella=driver.findElement (By.xpath("//img[@class='s-image'][1]"));
            Thread.sleep(5000);
           bestNutella.click();
//           WebElement resultElement=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
//            System.out.println(resultElement.getText());
        }



    }


