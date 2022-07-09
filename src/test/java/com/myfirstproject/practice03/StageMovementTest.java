package com.myfirstproject.practice03;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class StageMovementTest extends TestBase {
    @Test
    public void stageMovements() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement image1 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[1]"));
        scrollIntoViewByJS(image1);
        Thread.sleep(3000);
//        hover over the product
        Actions actions = new Actions(driver);
        actions.moveToElement(image1).perform();
        Thread.sleep(3000);
        WebElement addToCartButton = driver.findElement(By.xpath("(//span[.='Add to cart'])[1]"));
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[1]")));//Product successfully added to your shopping cart
        String productText = product.getText();
        Assert.assertEquals("Product successfully added to your shopping cart",productText);
//        And verifies the color, size, quantity, price, shipping, Total Price
//        And verifies the color, size => Orange, S
        WebElement colourAndSize = driver.findElement(By.id("layer_cart_product_attributes"));
        Assert.assertEquals("Orange, S", colourAndSize.getText());
//       Verify Quantity is equal to 1
        WebElement quantity = driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']"));
        Assert.assertEquals("1",quantity.getText());
//        Assert the price is equal to "$16.51"
        WebElement price = driver.findElement(By.xpath("//span[@id='layer_cart_product_price']"));
        String expectedPrice = price.getText();
        Assert.assertEquals("$16.51",price.getText());
//        Assert that shipping is equal to "$2.00"
        WebElement shippingPrice = driver.findElement(By.xpath("//span[@class='ajax_cart_shipping_cost']"));
        Assert.assertEquals("$2.00",shippingPrice.getText());
//        Assert that total price is equal to "$18.51"   => (16.51 + 2.00 = 18.51)
        WebElement totalPrice = driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']"));
        Assert.assertEquals("$18.51",totalPrice.getText());
//        And clicks on Proceed to checkout
        driver.findElement(By.linkText("Proceed to checkout")).click();
//      Verify that user is on the summary stage, VERIFY => SHOPPING-CART SUMMARY is displayed
        WebElement cartSummary = driver.findElement(By.id("cart_title"));
        Assert.assertTrue(cartSummary.isDisplayed());
//        Then verify the product is in stock
        WebElement inStock = driver.findElement(By.xpath("//span[@class='label label-success']"));
        Assert.assertEquals("In stock", inStock.getText());
//        Then verify the Unit price matches the price that is on the Add To Card page
        WebElement unitPrice = driver.findElement(By.xpath("//span[@id='product_price_1_1_0']"));
        String actualUnitPrice = unitPrice.getText();
        Assert.assertEquals(expectedPrice,actualUnitPrice);
//        And user clicks on + sign
        driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
        Thread.sleep(3000);
//        Then verifies the TOTAL price is 2*price+shipping => 2 * 16.51 + 2.00 = 35.02
        WebElement totalPrice2 = driver.findElement(By.xpath("//span[@id='total_price']"));
        Assert.assertEquals("$35.02",totalPrice2.getText());///=====>
////And click on Proceed to checkout
//        driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
//
//        //Then verify sign-in page displayed
//        WebElement authentication = driver.findElement(By.xpath("//h1[@class='page-heading']"));
//        Assert.assertTrue(authentication.isDisplayed());
//
//        //Then the user enters a username password and sign in
//        //driver.findElement(By.linkText("Sign in")).click();
//        WebElement userNameBox = driver.findElement(By.name("email"));
//        scrollIntoViewByJS(userNameBox);
//        String userName = "omeramca@gmail.com";
//        String password = "Qazxcv123?";
//        setValueByJS(userNameBox,userName);
//        driver.findElement(By.xpath("//input[@data-validate='isPasswd']")).sendKeys(password);
//        driver.findElement(By.id("SubmitLogin")).click();
//        //driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
//
//        //Then Verify user is on the Address stage
//        String actualAddresses = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
//        String expectedAddress = "ADDRESSES";
//        Assert.assertTrue(expectedAddress.equalsIgnoreCase(actualAddresses));
//
//        //And click on Proceed to checkout
//        driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
//
//        //Then verify user moves to the Shipping stage(SHIPPING)
//        String actualShipping = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
//        String expectedShipping = "SHIPPING";
//        Assert.assertTrue(expectedShipping.equalsIgnoreCase(actualShipping));
//
//        //And click on Proceed to checkout
//        driver.findElement(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']")).click();
//
//        //Then verify the error message: You must agree to the terms of service before continuing.
//        String actualErrorMessage = driver.findElement(By.xpath("//p[@class='fancybox-error']")).getText();
//        String expectedErrorMessage = "You must agree to the terms of service before continuing.";
//        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
//
//        //Then click on x to exit out
//        driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
//
////        //And click on the Terms of service checkbox
////        selectCheckBox("//input[@name='cgv']");
//
//        //And click on Proceed to checkout
//        driver.findElement(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']")).click();
//
//        //Then verify a user is on the Payment stage(PLEASE CHOOSE YOUR PAYMENT METHOD)
//        String actualPayment = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
//        String expectedPayment = "PLEASE CHOOSE YOUR PAYMENT METHOD";
//        Assert.assertTrue(expectedPayment.equalsIgnoreCase(actualPayment));
//
//        Thread.sleep(3000);

    }
}




