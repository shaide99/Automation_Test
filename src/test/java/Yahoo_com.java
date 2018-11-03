import ReusableObject.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Yahoo_com {


    public static void main(String[]args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\smiah\\Desktop\\Maven_Project\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        WebDriver driver = new ChromeDriver(options);

        String[]cities=new String[5];
        cities[0]="Brooklyn";
        cities[1]="Manhattan";
        cities[2]="Long island";
        cities[3]="Bronx";
        cities[4]="queens";

        for (int i=0;i<cities.length;i++){

            driver.get("https://www.google.com");

            Reusable_Methods.sendKeysMethod(driver,"//*[@name='q']",cities[i],"Search box");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            String mysearchResult=driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
            System.out.println(" my result is " + mysearchResult);





        }

   driver.quit();

    }
}
