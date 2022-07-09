package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day05DropDownExtra {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      driver.get("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void selectByVisibleText(){
        //1. Locate the dropdown
     WebElement dropDown= driver.findElement(By.xpath("//select[@id='dropdown']"));

//2. create a select object
     Select select = new Select(dropDown);
        List<WebElement> getDropDownOptions=select.getOptions();

        getDropDownOptions.stream().forEach(t-> System.out.println(t.getText()));//lambda
        //3.print Expected Is Not Equal Actual if there are not 3 elements in the dropdown
      int numberOfDropDownElement=getDropDownOptions.size();
        Assert.assertEquals("Expected Is Not Equal Actual",numberOfDropDownElement,3);
    }
}
