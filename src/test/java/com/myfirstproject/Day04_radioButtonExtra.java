package com.myfirstproject;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_radioButtonExtra {
    WebDriver driver;
    Faker faker=new Faker();
    @Before
            public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void testRadioButton(){
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("reg_email__")).sendKeys(faker.phoneNumber().cellPhone());
driver.findElement(By.name("reg_passwd__")).sendKeys(faker.internet().password());


WebElement monthDropdown=driver.findElement(By.name("birthday_month"));
Select selectMonth=new Select(monthDropdown);
        selectMonth.selectByVisibleText("Jan");

        WebElement dayDropDown=driver.findElement(By.name("birthday_day"));
        Select selectDay= new Select(dayDropDown);
        selectDay.selectByValue("16");


        WebElement yearDropdown=driver.findElement(By.name("birthday_year"));
        Select selectYear=new Select(yearDropdown);
        selectYear.selectByValue("2000");
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
driver.findElement(By.name("websubmit")).click();

    }



}
