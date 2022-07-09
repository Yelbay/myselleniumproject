package com.myfirstproject;


   import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Day11_ExtentReportFromScrach extends TestBase{
        protected ExtentReports extentReports;
        protected ExtentHtmlReporter extentHtmlReporter;
        protected ExtentTest extentTest;
    //    later on we will move these objects to TestBase class

    /**
     * *Extent Reports:
     * HTML reporting tool, it gives us HTML reports
     * It helps us to save our test steps and results
     * We can add also screenshots.
     *
     * We will create 3 objects
     * 1. ExtentReports extendReport => we need this object to start reporting.
     * extentReports.flush(); we use this method to generate and end the report
     *
     * 2.ExtentHtmlReporter extendHtmlReporter => it helps us to configuration of reports.
     * We will use it to set the path where report will be saved
     *
     * 3.ExtentTest extentTest => To add information, to add logs.
     * We will add some explanation to our test steps
     */
        @Test
        public void extentReportTest(){
//        Report PATH= creates the html report right under test-output
            String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String path = System.getProperty("user.dir")+"/test-output/report/"+currentDate+"test_report.html";
//      Create html reporter using the path
            extentHtmlReporter = new ExtentHtmlReporter(path);
//        Create extent report
            extentReports = new ExtentReports();
//        Add custom information
            extentReports.setSystemInfo("Environment","Test Environment");
            extentReports.setSystemInfo("Browser","Chrome");
            extentReports.setSystemInfo("Application","TechProEd");
            extentReports.setSystemInfo("SQA","John");
            extentHtmlReporter.config().setDocumentTitle("TechProEd BlueCar");
            extentHtmlReporter.config().setReportName("TechProEd Extent Report");
//        Attach html and extent reports
            extentReports.attachReporter(extentHtmlReporter);
//        Report is complete. Now we just need to create test using extentTest object
            extentTest = extentReports.createTest("My Project Extent Report","This is for smoke test report");
//        Done with configuration......
//        logging the test steps in the report
            extentTest.info("User goes to google home page");
            extentTest.pass("User goes to google home page");
            extentTest.fail("User goes to google home page");
            extentTest.skip("User goes to google home page");
            extentTest.warning("User goes to google home page");
            driver.get("https://www.google.com");
            extentTest.info("User search for cybertruck release date");
            driver.findElement(By.name("q")).sendKeys("Tesla Cybertruck release date"+ Keys.ENTER);
            extentTest.pass("Closing the browser");
//        Generating and Ending the report
            extentReports.flush();
        }
    }


