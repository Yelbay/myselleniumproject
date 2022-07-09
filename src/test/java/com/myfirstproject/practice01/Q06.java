package com.myfirstproject.practice01;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q06 extends TestBase {

// go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// click on the second emoji
// click all the second emoji elements
// fill the form,(Fill the form with the texts you want)
// press the apply button
@Test
    public void animalTest(){
    driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
    driver.switchTo().frame(iframe);
    // click on the second emoji
    WebElement secondEmoji=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
    secondEmoji.click();

    /*
    List<WebElement> emojies = driver.findElements(By.xpath("//img[@id='emoji']"));
for (WebElement emoji:emojies){
    emoji.click();
}
     */
}

}
