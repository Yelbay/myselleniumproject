package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Day10_Screenshots extends TestBase {
    /*
     * In Testing, Screenshot is very essential
     * Documentation of test results
     *
     * Test Reports should have test cases(test steps), test result(fails, passes), screenshots
     *
     * If our test fails, we need screenshot to raise a bug ticket.
     * If our test passes, we should get a screenshot as a proof.
     *
     * With Selenium 3 & 4 we can get screenshot by using TakeScreenshot class and getScreenshotAs()
     * to be able to get screenshot of a webpage
     *
     * With Selenium 4, we can take screenshot of a specific element
     *
     *
     * */
//        1. Taking screenshot using getScreenshotAs
    public void takeScreenShot() throws IOException {

        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        /*
        Alternatively
        TakesScreenshot ts=(TakesScreenshot)driver;
        File image = ts.getScreenshotAs(OutputType.FILE);
         */
//        2. We will save the image in this path. using currentDate for getting different name every time
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        System.out.println(currentDate);
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+"test-image.png";
        File finalPath = new File(path);
        FileUtils.copyFile(image,finalPath);
    }
    @Test
    public void screenshotTest() throws Exception {
        driver.get("https://www.google.com");
//        create a reusable method
        takeScreenShot();
//        locating input, typing tesla cybertruck, and clicking enter
        driver.findElement(By.name("q")).sendKeys("tesla cybertruck"+ Keys.ENTER);
        takeScreenShot();
    }
    /*
     * How to do capture screenshot in your automation framework?/How do you get screenshot in selenium?
     * I use getScreenshotas method to capture teh screenshot.
     * Actually we have a reusable methods to capture the screenshot
     *System.getProperty("user.dir") -> gives the path of the current folder
     * System.getProperty("user.home") -> gives you the user folder
     * */


}




