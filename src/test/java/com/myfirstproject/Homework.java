package com.myfirstproject;

import com.myfirstproject.utilities.AmazonTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework extends AmazonTestBase {
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


        // Create A Method dropdownTest
        // Go to https://www.amazon.com/
        // Find the element of the dropdown element. HINT: By.id("searchDropdownBox")
        @Test
        public void dropdowntest() {
            driver.get("https://www.amazon.com/");
            // Go to https://www.amazon.com/
            //dropdown element.
            WebElement dropdowninmainpage = driver.findElement(By.id("searchDropdownBox"));
            Select select1 = new Select(dropdowninmainpage);
            dropdowninmainpage.click();
//Print the first selected option and assert if it equals "All Departments".
            WebElement firstdropdown = select1.getFirstSelectedOption();
            System.out.println("first selected option: " +firstdropdown.getText());
            String actualfirstselect = firstdropdown.getText();
            String expextedfirstselect = "All Departments";
            Assert.assertEquals("mismatch", expextedfirstselect, actualfirstselect);

        }

        //   Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices".
        //    (after you select you need to use get first selected option method).
        //1.way
        @Test
        public void indexOfThird1() throws InterruptedException {

            driver.get("https://www.amazon.com/");
            Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
            select.selectByIndex(3);

            WebElement firstOption = select.getFirstSelectedOption();
            System.out.println("index of three; " + firstOption.getText());

            String actualindexofthree = firstOption.getText();
            String expected = "Amazon Devices";

            Assert.assertFalse(actualindexofthree.contains("Amazon Devices"));
            //  Assert.assertEquals("mismatch",expected,actualindexofthree);
        }


        //Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices".
        //2.way
        @Test
        public void indexOfThird2() throws InterruptedException {
            // Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices"
            driver.get("https://www.amazon.com/");
            Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
            select.selectByIndex(3);

            List<WebElement> actualoptions = select.getOptions();

            int sizeOfoptions = actualoptions.size();
            for (int i = 0; i < sizeOfoptions; i++) {
                String actualalloptions = actualoptions.get(i).getText();
                // System.out.println(options);
                String actualindexofthree = actualoptions.get(3).getText();
                // System.out.println(expop);
                String expectedindexofthree = "Amazon Devices";

                Assert.assertFalse(actualindexofthree.contains("Amazon Devices"));
                // Assert.assertEquals("mismatch",expectedindexofthree,actualindexofthree);
            }
        }

        // Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        @Test
        public void printallofthem() {
            //Print all of the dropdown options-getOptions()
            driver.get("https://www.amazon.com/");
            Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
            List<WebElement> allofthedropdown = select.getOptions();
            System.out.println("Print All Of Them :");
            for (WebElement each : allofthedropdown) {
                System.out.println("" + each.getText());
            }
        }

        //Print the the total number of options in the dropdown
        @Test
        public void size() {
            driver.get("https://www.amazon.com/");
            Select select = new Select(driver.findElement((By.id("searchDropdownBox"))));
            List<WebElement> sizeofoptions = select.getOptions();
            int ttlnumofdropdown = sizeofoptions.size();
            System.out.println("TTL number of options: " + ttlnumofdropdown);

        }
        // Assert if 'Appliances' is a drop down option. Print true if "Appliances" is an option.
        @Test
        public void Verify_the_dropdown() {

            driver.get("https://www.amazon.com/");
            WebElement appliances = driver.findElement((By.id("searchDropdownBox")));
            Select select = new Select(appliances);
            // or select.selectByIndex(7);
            select.selectByVisibleText("Appliances");

            List<WebElement> alldropdownOptions = select.getOptions();

            String onlyappliance = "";
            for (WebElement eachOptions : alldropdownOptions) {
                System.out.println("with each getText :" + eachOptions.getText());
                if (eachOptions.getText().equals("Appliances")) {
                    onlyappliance += eachOptions.getText();

                }
            }

            System.out.println("str appliances ; " + onlyappliance);
            String actualappliance = onlyappliance;
            Assert.assertEquals("not exist", "Appliances", actualappliance);
            Assert.assertTrue(actualappliance.contains("Appliances"));

        }


        //BONUS: Assert if the dropdown is in Alphabetical Order
        @Test
        public void alphabetical(){
            driver.get("https://www.amazon.com/");
            WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
            Select select = new Select(dropdown);

            List<WebElement> allofthedropdown = select.getOptions();

            List<String> actualalphabetical = new ArrayList<>();
            List<String> expectedalphabetical2= new ArrayList<>();

            for(WebElement eachoption : allofthedropdown){
                actualalphabetical.add(eachoption.getText());
            }
            for(String each : actualalphabetical){
                expectedalphabetical2.add(each);
            }

            Collections.sort(expectedalphabetical2);
            Assert.assertFalse(expectedalphabetical2.equals(actualalphabetical));

        }

    }

