package com.myfirstproject.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q03Extra extends TestBase {
    // go to amazon homepage
    // hover mouse over the hello,signIn element at the top right
    // Click on the Create list link in the menu that opens
    // and verify that title is equal to "Your List"


    @Test
    public void test(){
     driver.get("https://www.amazon.com/");
     driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).click();

     Actions actions=new Actions(driver);
     WebElement helloElement=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
     actions.moveToElement(helloElement).perform();
WebElement listElement=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
actions.click(listElement).perform();
        Assert.assertEquals("Your List",driver.getTitle());
    }

}
