package com.myfirstproject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTestBase {


        //    Create A Class: AmazonDropdown

        public WebDriver driver;

        @Before
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.amazon.com/");

        }

        @After
        public void teardown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }

