package com.myfirstproject.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q05Extra extends TestBase {

    @Test
    public void test() {
        driver.get("https://www.facebook.com");
        driver.findElement(By.linkText("Create new account")).click();
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname])"));

        Actions actions = new Actions(driver);
        actions.click(nameBox)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("alican")
                .sendKeys(Keys.TAB);


    }

}
