package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class Day10_ScreenShotSignInButton extends TestBase {
    //    screenshot of Google sign In button
    @Test
    public void screenShotSignIn() throws IOException {
        driver.get("https://www.google.com");
        WebElement signIn = driver.findElement(By.xpath("//a[@class='gb_1 gb_2 gb_7d gb_7c']"));
        File signInImage = signIn.getScreenshotAs(OutputType.FILE); //we capture but not save it yet
//       Save the image to path
        File finalPath = new File("./test-output/Screenshots/SignIn.png");
        FileUtils.copyFile(signInImage,finalPath);

    }
}


