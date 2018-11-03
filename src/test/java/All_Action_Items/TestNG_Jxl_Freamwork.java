package All_Action_Items;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static ReusableObject.Reusable_Methods.*;
public class TestNG_Jxl_Freamwork {

    //declare webdriver here since it's a global variable
    WebDriver driver;
    // declare all readable and writeable excel workbook and and worksheet here since it's global
    Workbook readable;
    Sheet readbleSheet;
    WritableWorkbook writable;
    WritableSheet writableSheet;
    SoftAssert softAssert1=new SoftAssert();
    int rows;

    @BeforeSuite
    public void InvokingBrowser() throws IOException, BiffException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\smiah\\Desktop\\Maven_Project\\src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver(options);
        Reusable_Methods.GetTitleMethod(driver, "Google1", "Google", " ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        readable = Workbook.getWorkbook(new File("src\\main\\resources\\mlcalc.xls"));
        readbleSheet=readable.getSheet(0);
        //defining the writable wordbook
         writable = Workbook.createWorkbook(new File("src\\main\\resources\\Write.xls"), readable);
        writableSheet =writable.getSheet(0);
        // define the row count
        rows=readbleSheet.getRows();
        }
    @AfterSuite
    public void quiteBrowser() throws IOException, WriteException {
       writable.write();
       writable.close();
       readable.close();
       driver.quit();
    }
    @Test

    public void TestCase1() throws InterruptedException, WriteException, IOException, BiffException {

        for (int i = 1; i < rows; i++) {
            String PurchasePrice= readbleSheet.getCell(0, i).getContents();
            String DownPayment = readbleSheet.getCell(1, i).getContents();
            String InterestRate = readbleSheet.getCell(2, i).getContents();
            String ZipCode = readbleSheet.getCell(3, i).getContents();
            String PaymentMonth= readbleSheet.getCell(4, i).getContents();
            String PaymentYear= readbleSheet.getCell(5, i).getContents();

            driver.navigate().to("https://mlcalc.com");
            softAssert1.assertEquals("Mortgage Loan Calculator", driver.getTitle());

            clearMethod(driver,"//*[@name='ma']","clearTextfield");
            sendKeysMethod(driver,"//*[@name='ma']",PurchasePrice,"Myprince");
            clearMethod(driver,"//*[@name='dp']","ClearDownpaymentFiled");
            sendKeysMethod(driver,"//*[@name='dp']",DownPayment,"downpayment");
            clearMethod(driver,"//*[@name='ir']","clearintersrateField");
            sendKeysMethod(driver,"//*[@name='ir']",InterestRate,"interestrate");
            clearMethod(driver,"//*[@name='zipCode']","clearzipcodetextfield");
            sendKeysMethod(driver,"//*[@name='zipCode']",ZipCode,"zipcode");
            WebElement mydrpdwon = driver.findElement(By.xpath("//*[@name='sm']"));
            Select month = new Select(mydrpdwon);
            month.selectByVisibleText(PaymentMonth);
            WebElement mydropdwon2 = driver.findElement(By.xpath("//*[@name='sy']"));
            Select yeardropdwon = new Select(mydropdwon2);
            yeardropdwon.selectByVisibleText(PaymentYear);
            Thread.sleep(3000);
            clickMethod(driver,"//*[@class='button-calculate action']","Calculate");
            WebElement mntpay = driver.findElements(By.xpath("//*[@class='big']")).get(0);
            String monthlyresult = mntpay.getText();
            System.out.println(" this is my monthly payment" + monthlyresult);
            Thread.sleep(4000);
            WebElement mntpay1 = driver.findElements(By.xpath("//*[@class='big']")).get(2);
            String  Mortgage_payoff_date= mntpay1.getText();
            System.out.println(" this is my monthly payment" + Mortgage_payoff_date);

           // add label for monthly payments

            Label label = new Label(6, i, monthlyresult);
            writableSheet.addCell(label);
            Label labe2 = new Label(7, i, Mortgage_payoff_date);
            writableSheet.addCell(labe2);

        }
softAssert1.assertAll();

    }
}