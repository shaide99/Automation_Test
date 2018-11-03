package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Abstract_Class {

    public static WebDriver driver=null;
    public static ExtentReports reports=null;
    public static ExtentTest logger=null;
    public static JavascriptExecutor jse=null;



    @BeforeSuite

    public void OpenBroser(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized", "incognito","disable-infobars");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        reports = new ExtentReports("src\\main\\java\\Report_Folder\\ExtentReport.html", true);

        //define the javascript
        jse = (JavascriptExecutor)driver;

    }
    @Parameters("browser")
    @BeforeMethod
    public void loggerSession (Method MethodName){
        logger= reports.startTest(MethodName.getName());
        logger.log(LogStatus.INFO," Automation test scenario started....");
    }

    @AfterMethod
    public void EndLogger (Method MethodName) {
        logger = reports.startTest(MethodName.getName());
        logger.log(LogStatus.INFO, " Automation test scenario started....");
    }
@AfterSuite
    public void CloseBrowser(){
    reports.endTest(logger);
    reports.flush();
    reports.close();
    //driver.quit();
    logger.log(LogStatus.INFO,"Automation Test Suite Ended....");

}


}
