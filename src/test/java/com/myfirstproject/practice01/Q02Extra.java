package com.myfirstproject.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Q02Extra {
    /*
    //  ...Exercise2...
    // Create a new class under Q02
    // Set Path
    // Create chrome driver
    // Maximize the window
    // Open google home page https://www.google.com/.
    // Wait for 3 seconds
    // Go to the "https://www.amazon.com"
    // Get the title and URL of the page
    // Check if the title contains the word "oto" print console "Title contains oto" or "Title does not contain oto"
    // Check if the URL contains the word "oto" print console "URL contains oto" or "URL does not contain oto"
    // Then go to "https://www.gittigidiyor.com"
    // Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
    // Back to the previous webpage, https://www.amazon.com"
    // Refresh the page
    // Navigate to gittigidiyor.com
    // Wait for 3 seconds
    // Close the browser
     */
WebDriver driver;
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.manage().window().maximize();


    }
    @Test
    public void test() throws InterruptedException {
    driver.get("https://www.google.com/");
    Thread.sleep(2000);
    driver.get("https://www.amazon.com");
    String amazonTitle=driver.getTitle();
    String amazonUrl=driver.getCurrentUrl();
if(amazonTitle.contains("auto")){
    System.out.println("Title contains auto");

}else{
    System.out.println("Title doesnt contains auto");
}
if(amazonUrl.contains("auto")){
    System.out.println("Url contains auto");
}else{
    System.out.println("Url doesnt contains auto");
}
driver.get("https://www.gittigidiyor.com");
String gittigidiyorTitle=driver.getTitle();
String gittiUrl=driver.getCurrentUrl();
if (gittigidiyorTitle.contains("site")){
    System.out.println("Title contains site");
}else{
    System.out.println("Title does not contains site");
}
driver.navigate().back();
driver.navigate().refresh();

Thread.sleep(2000);
}
    @After
    public void tearDown(){
driver.close();
    }
            }



