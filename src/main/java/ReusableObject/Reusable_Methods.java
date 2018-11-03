package ReusableObject;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Reusable_Methods {
    //method for clicking on an element
    public static void clickMethod(WebDriver driver, String locator, String elementName) {

        try {
            System.out.println("Clicking on element " + elementName);
            //store the locator into WebElement variable
            WebElement clickbtn = driver.findElement(By.xpath(locator));
            clickbtn.click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + elementName);
        }
    }

    //drodown method by visible text

    public  static void selectBytext(WebDriver driver, String locator, String value, String elementName){
        try {
            System.out.println(" Selecting " + value+ " from dropdown " + elementName);
            //define the web element
            WebElement element=driver.findElement(By.xpath(locator));
            // define the select command
            Select select=new Select (element);
            //select by visible text
            select.selectByVisibleText(value);

        }catch (Exception error){
            System.out.println(" Unable to select a value from dropdwon " + elementName+ "" + error);
        }
    }
   // Mehtod for getText

    public static void  captureText(WebDriver driver, String locator, int indexNumber, String elementName){

        String textValue= null;

        try {

            System.out.println(" Capturing text " + elementName);
            textValue=driver.findElements(By.xpath(locator)).get(indexNumber).getText();


        }catch (Exception Error){
            System.out.println(" element is unable to ");

        }
    }


// method to naviaging to a page
    public  static void navigate(ExtentTest logger, WebDriver driver, String url){
        try {
            System.out.println(" nAVIGATING TO " + url);
            driver.navigate().to(url);
        }catch (Exception error){
            System.out.println(" Unable to navigate to the url " + error);
        }
    }
    public static void clearMethod(WebDriver driver, String locator, String elementName) {
        try {
            System.out.println("Clicking on element " + elementName);
            //store the locator into WebElement variable
            WebElement clearbtn = driver.findElement(By.xpath(locator));
            clearbtn.clear();
        } catch (Exception err) {
            System.out.println("Unable to Clear on element " + elementName);
        }
    }


    //method for clicking on an element by index
    public static void clickMethodByIndex(WebDriver driver, String locator, int indexNumber, String elementName) {

        try {
            System.out.println("Clicking on element " + elementName);
            //store the locator into WebElement variable
            WebElement clickbtn = driver.findElements(By.xpath(locator)).get(indexNumber);
            clickbtn.click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + elementName);
        }//end of try catch
    }//end of click by index method

    //method for submitting on an element
    public static void submitMethod(WebDriver driver, String locator, String elementName) {
        try {
            System.out.println("Submitting  on element " + elementName);
            //store the locator into WebElement variable
            WebElement submitBtn = driver.findElement(By.xpath(locator));
            submitBtn.submit();
        } catch (Exception err) {
            System.out.println("Unable to Submit on element " + elementName + " " + err);
        }//end of try catch
    }//end of submit method

    //method for entering on an element
    public static void sendKeysMethod(WebDriver driver, String locator, String userInput, String elementName) {
        try {
            System.out.println("Entering " + userInput + " in element " + elementName);
            //store the locator into WebElement variable
            WebElement input = driver.findElement(By.xpath(locator));
            input.sendKeys(userInput);
        } catch (Exception err) {
            System.out.println("Unable to send info on element " + elementName);
        }
    }

    public static void GetTitleMethod(WebDriver driver, String Title, String expectedTitle, String ActualTitle) {
        String title = driver.getTitle();
        //match the expected title with actual

        if (title.equals(("Title"))) {
            System.out.println("expectedTitle");

        } else {
            System.out.println(" ActualTitle....." + title);


        }
    }
public static String getText(WebDriver driver,String locator, int indexNum, String elementName){
    String text = null;
    try {
            WebElement texValue=driver.findElements(By.xpath(locator)).get(indexNum);
            text=texValue.getText();

        }catch (Exception error){
            System.out.println(" Unable to capture text from element " + elementName);
        }

    return text;
    }


}


