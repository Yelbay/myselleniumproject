package com.myfirstproject.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q05Extra {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(driver, 100);
        deleteButton(driver, 30);
    }


    public void createButtons(WebDriver driver, int number) {
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i <= number; i++) {
            addButton.click();
        }
    }

    private void deleteButton(WebDriver driver, int numberOfDelete) {
        List<WebElement> elementBefore = driver.findElements(By.xpath("//button[@class='added-manually']"));
        int sizeBeforeDelete = elementBefore.size();
        int counter = 0;
        for (WebElement w : elementBefore) {
            counter++;
            if (counter > numberOfDelete) {
                break;
            }
            w.click();
        }
        List<WebElement> elementAfter = driver.findElements(By.xpath("//button[@class='added-manually']"));
        int sizeAfterDelete = elementAfter.size();

        Assert.assertEquals(sizeBeforeDelete-numberOfDelete,sizeAfterDelete);
    }

    @After
        public void tearDown(){
            driver.quit();
        }
    }

