import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class scrolling {

   @Test
    public static void Scrolling(){

       System.setProperty("webdriver.chrome.driver", "C:\\Users\\smiah\\Desktop\\Maven_Project\\src\\main\\resources\\chromedriver.exe");

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--start-maximized", "--incognito");
       WebDriver driver = new ChromeDriver(options);
       driver.navigate().to("https://www.mortagacalculator.net/");

       JavascriptExecutor JSE=(JavascriptExecutor)driver;
       WebElement calculate= driver.findElement(By.xpath("//*[@value='Calculate Now']"));
       JSE.executeScript("arguments[0].scrollIntoView(true);", calculate);




    }
}
