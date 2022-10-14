package com.myfirstproject.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q01Extra extends TestBase {

    @Test
    public void test() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// click on the second emoji
// click all the second emoji elements
// fill the form,(Fill the form with the texts you want)
// press the apply button
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement secondElement=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondElement.click();

        List<WebElement> emojees=driver.findElements(By.xpath("//div[@id='nature']/div/img"));
//        for(WebElement w:emojees){
//            w.click();
//        }
        emojees.stream().forEach(t->t.click());
        driver.switchTo().defaultContent();
       List<WebElement> textBox=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
       List<String> words=new ArrayList<>(Arrays.asList("This","iframe","example","looks","very","funny","does","not","it","?","!"));
// click all the second emoji elements
for(int i=0;i<textBox.size();i++){
    textBox.get(i).sendKeys(words.get(i));
}
//div[@id='nature']/div/img
WebElement apply=driver.findElement(By.xpath("//button[@id='send']"));
apply.click();
    }
}

