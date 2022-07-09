package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Day10_WebTablesExtra extends TestBase {
    @Test
    public void printTable(){
        //Task 1: Print the entire table
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("*****Print Table*******");
        WebElement table=driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());

        System.out.println("*****Printing entire Table Data*******");
       List<WebElement> tableData=driver.findElements(By.xpath("//table[@id='table1']//td"));
        for(WebElement eachData : tableData){
            System.out.println(eachData.getText());

        }



        //Task 2: Print the All ROWS

        }
    @Test
    public void getRows() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("*****Print Rows*******\"");
        List<WebElement> allRow = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        for (WebElement eachRow : allRow) {
            System.out.println(eachRow.getText());
        }

        System.out.println(allRow.get(3).getText());//this for specific row
    }
    @Test
    public void getLastRow(){
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("******Print Last Row*******");
       WebElement lastRowData= driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[last()]"));
        System.out.println(lastRowData.getText());




    }
    @Test
    public void getColumn5(){
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("******Print Column 5 ******");
        List<WebElement> column5Data= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
//column5Data.stream().forEach( t -> System.out.println( t.getText() + " "));//this is lambda
        for (WebElement eachColumn:column5Data) {
            System.out.println(eachColumn.getText());
        }

    }
    //Write the method that accepts 2 parameters
    //Parameter 1= row number
    //Parameter 2= column number
    //print Data (2,3);=> prints data in 2nd row 3rd column




    //This methods for dynamic methods
    @Test
    public void printDataTest(){

        printData(2,3);//fbach@yahoo.com
        printData(4,6);//edit delete
        printData(2,4,"table2");
        printData(2,3,"table1");
    }
    public void printData(int row,int column){
        driver.get("https://the-internet.herokuapp.com/tables");
       // //table[@id='table1']//tbody//tr[4]//td[2]
        //table[@id='table1']//tbody//tr[3]//td[4]
        //table[@id='table1']//tbody//tr[1]//td[3]
        String xpath="//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]";
       WebElement cellData= driver.findElement(By.xpath(xpath));
        System.out.println(cellData.getText());
    }
    public void printData(int row,int column,String tableID) {//this is more dynamic
        driver.get("https://the-internet.herokuapp.com/tables");
        // //table[@id='table1']//tbody//tr[4]//td[2]
        //table[@id='table1']//tbody//tr[3]//td[4]
        //table[@id='table1']//tbody//tr[1]//td[3]
        String xpath = "//table[@id='" + tableID + "']//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cellData = driver.findElement(By.xpath(xpath));
        System.out.println(cellData.getText());

    }

}
