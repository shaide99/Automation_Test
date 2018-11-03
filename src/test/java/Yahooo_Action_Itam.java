import ReusableObject.Reusable_Methods_Loggers;
import Utilities.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Yahooo_Action_Itam extends Abstract_Class {

    @Test
    public  void yahooserach() throws IOException {

        Reusable_Methods_Loggers.navigate(logger,driver, "https://www.yahoo.com");
        String actualTitle=driver.getTitle();
        if (actualTitle.equals("yahoo")){
            logger.log(LogStatus.PASS,"Title matches as yahoo");

        }else{
            logger.log(LogStatus.FAIL," Ttile does not match " + actualTitle);
        }

        List<WebElement>ListCount=driver.findElements(By.xpath("//*[contians(@class,'D(ib) Mstrart(21px) Mend(13PX)'] "));
        logger.log(LogStatus.INFO, "link count is "  + ListCount.size());
        System.out.println(" List cound is " + ListCount.size());

        Reusable_Methods_Loggers.sendKeysMethod(logger,driver,"//*[@id=uh-search-box']","Nutrition","Serach box");

//String searchresult= Reusable_Methods_Loggers.captureText(driver,"//")

    }
}
