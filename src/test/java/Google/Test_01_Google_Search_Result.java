package Google;
import ReusableObject.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static ReusableObject.Reusable_Methods.clickMethod;
import static ReusableObject.Reusable_Methods.sendKeysMethod;
import static ReusableObject.Reusable_Methods.submitMethod;

public class Test_01_Google_Search_Result {

    // global or shared variables across methods need to be declared
    // before calling annotation
    WebDriver driver;
    WebElement Map;
    String[] mycounties;
    String[] Mycounties = new String[5];
    String[] myPurchaseprice;


    @BeforeSuite

    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\smiah\\Desktop\\Maven_Project\\src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver(options);
        Reusable_Methods.GetTitleMethod(driver, "Google1", "Google", " ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void Testcase1() throws InterruptedException {
        Mycounties[0] = "Brookyn";
        Mycounties[1] = "Bronx";
        Mycounties[2] = "Manhattan";
        Mycounties[3] = "Long island";
        Mycounties[4] = "Queens";
        for (int i = 0; i < Mycounties.length; i++) {
            driver.navigate().to("https://www.google.com/");
            sendKeysMethod(driver, "//*[@name='q']", Mycounties[i], " searchbutton");
            submitMethod(driver, "//input[@name='btnK']", "Search result");

            try {
                String searchresult = driver.findElement(By.xpath("//div[@id='resultStats']")).getText();
                String[] searchNumber = searchresult.split(" ");
                System.out.println(" My serach number is for " + Mycounties[i] + searchresult);
            } catch (Exception Error) {
                System.out.println(" Element is not found " + Error);
            }
            try {
                Thread.sleep(4000);
                driver.findElement(By.xpath("//a[contains(text(),'Maps')]")).click();
            } catch (Exception Error2) {
                System.out.println(" map Element is not found " + Error2);
            }
        }

    }
}