package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06AlertExtra {
    //    https://the-internet.herokuapp.com/javascript_alerts

    //    acceptAlert() => click on the first alert,
//    verify the text “I am a JS Alert” ,
//    click OK ,
//    and Verify “You successfully clicked an alert”
//
//    dismissAlert()=> click on the second alert,
//    verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”

    //    sendKeysAlert()=> click on the third alert,
//    verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello World”
    WebDriver driver;
@Before
public void setUp(){
    WebDriverManager.chromedriver().setup();
  driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}
@Test
    public void acceptAlert() throws InterruptedException {
//        click on the first alert,
driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
Thread.sleep(5000);
//    verify the text “I am a JS Alert”
String actualAlertText=driver.switchTo().alert().getText();
String expectedAlertText="I am a JS Alert";
    Assert.assertEquals(expectedAlertText,actualAlertText);
    //    click OK
    driver.switchTo().alert().accept();
    //    and Verify “You successfully clicked an alert”
    String actualResultText=driver.findElement(By.xpath("//p[@id='result']")).getText();
    String expectedResultText="You successfully clicked an alert";
    Assert.assertEquals(expectedResultText,actualResultText);
    //    dismissAlert()=> click on the second alert,
    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    //    verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
    String actualJSAlertText=driver.switchTo().alert().getText();
    String expectedJSAlertText="I am a JS Confirm";
    Assert.assertEquals(expectedAlertText,actualAlertText);
            driver.switchTo().alert().dismiss();
    //    verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
  String actualJsAlertDismissText= driver.findElement(By.xpath("//p[@id='result']")).getText();
    String expectedJsAlertDismissText="You clicked: Cancel";
    Assert.assertEquals(expectedJsAlertDismissText,actualJsAlertDismissText);
driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
String actualJsPrompText=driver.switchTo().alert().getText();
String expectedJsPrompText="I am a JS prompt";
Assert.assertEquals(expectedJsPrompText,actualJsPrompText);
driver.switchTo().alert().sendKeys("Hello World");
driver.switchTo().alert().accept();
String actualCustomResultText=driver.findElement(By.xpath("//p[@id='result']")).getText();
String expectedCustomResultText="You entered: Hello World";
Assert.assertEquals(expectedCustomResultText,actualCustomResultText);
}
}
