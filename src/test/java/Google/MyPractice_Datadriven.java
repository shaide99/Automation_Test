package Google;

import ReusableObject.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyPractice_Datadriven {
    // declare the global driver
    WebDriver driver;
    Workbook readable;
    Sheet readablesheet1;
    WritableWorkbook writeback;
    WritableSheet writableShee1;
    int rows;


    @BeforeSuite
    public void InvkingBbroser() throws IOException, BiffException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\smiah\\Desktop\\Maven_Project\\src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        readable = Workbook.getWorkbook(new File("src\\main\\resources\\MyPractiiceGoogle.xls"));
        readablesheet1 = readable.getSheet(0);
        //defining the writable wordbook
        writeback = Workbook.createWorkbook(new File("src\\main\\resources\\MyWrittableGoogle.xls"), readable);
        writableShee1 = writeback.getSheet(0);
        // define the row count
        rows = readablesheet1.getRows();
    }

    @AfterSuite
    public void ClosingBrowser() throws IOException, WriteException {
        writeback.write();
        writeback.close();
        readable.close();
        driver.quit();



    }

    @Test
    public void Testcase1() throws InterruptedException, WriteException {


        for (int i = 1; i < rows; i++) {
            String cities1 = readablesheet1.getCell(0, i).getContents();

            driver.get("https://www.google.com");

            Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", cities1, "Search box");
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            Thread.sleep(1900);
            String mysearchResult = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
            System.out.println(" my result is " + mysearchResult);
            Label label = new Label(1, i, mysearchResult);
            writableShee1.addCell(label);

        }

    }


}