package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadedCorrectClass extends TestBase {
    /*
   Class Name: FileUploadTest
Method Name: fileUploadTest
When user goes to https://the-internet.herokuapp.com/upload
When user selects an image from the desktop
And click on the upload button
Then verify the File Uploaded!  Message displayed

    */
    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //locate choose file input button
        //find the path of the file that you want to
        //sendKeys(path)
        //click on upload button

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        String filePath="/Users/mujdatyelbay/Dropbox/Mac/Desktop/image.jpg";
        chooseFile.sendKeys(filePath);
        WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
        upload.click();//bu kisim file upload clasinda hatali burda duzelttim

        //    And click on the upload button
        driver.findElement(By.xpath("//input[@value='Upload']")).click();
        Thread.sleep(3000);
        //    Then verify the File Uploaded!  Message displayed
        String actualMessageText = driver.findElement(By.xpath("//h3")).getText();
        String expectedMessageText = "File Uploaded!";
        Assert.assertEquals(actualMessageText,expectedMessageText);
        /*
         * 1. Do Manual Testing first to understand the functionality
         *   -click on choose file
         *           - locate choose file input
         *   -select a file
         *           - use sendKeys(pathOfFile)
         *   -click upload
         *           -locate upload element and click on it
         *   -verify message : File Uploaded!
         *           -get the text of the message and do assertion
         * */

    }
}
