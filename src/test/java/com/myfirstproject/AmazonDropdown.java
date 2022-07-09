package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AmazonDropdown {

    /*
    Create A Class: AmazonDropdown
    Create A Method dropdownTest
    Go to https://www.amazon.com/
    Find the element of the dropdown element. HINT: By.id("searchDropdownBox")

    Print the first selected option and assert if it equals "All Departments".

    If it fails, then comment that code out and continue rest of the test case.

    Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices".
    (after you select you need to use get first selected option method).
    If it fails, then comment that code out and continue rest of the test case.

    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.

    Print the the total number of options in the dropdown

    Assert if 'Appliances' is a drop down option. Print true if "Appliances" is an option.
    Print false otherwise.
    BONUS: Assert if the dropdown is in Alphabetical Order
 */


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        }

        @Test
    public void dropdownTest(){
            //Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//this is for amazon changing address alert"We're showing you items that ship to CA. To see items that ship to a different country, change your delivery address."

        driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();// 'Click to Don't Change address alert' (handling alert)

           // Find the element of the dropdown element. HINT: By.id("searchDropdownBox")

            WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
Select select=new Select(dropdown);

        }


//        @After
//    public void tearDown(){
//
//        }


    }


