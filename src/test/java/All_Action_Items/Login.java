package All_Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {


public  static void main (String[]args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    ChromeOptions options = new ChromeOptions();

    options.addArguments("start-maximized", "incognito","disable-infobars");

    WebDriver driver = new ChromeDriver(options);

    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
     driver.navigate().to("https://ncia-qa.wwnorton.com/litweb");

        driver.findElement(By.xpath("//*[@id='gear_button_username']")).click(); 

        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@type='email']")).clear();
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("smiah@wwnorton.com");
        driver.findElement(By.xpath("//*[@id='password']")).clear();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password1234");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='login_dialog_button']")).click();
        Thread.sleep(15000);

        driver.quit();


        }
        }

