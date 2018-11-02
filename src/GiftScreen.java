import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GiftScreen {
    //Function for RadioButton selector test if both options available.
    protected static void RadioButtonSelector(WebDriver driver) throws InterruptedException {
        Thread.sleep(Long.parseLong("2000"));
        driver.findElement(Constants.forMyself).click();
        Thread.sleep(Long.parseLong("2000"));
        driver.findElement(Constants.giveGiftRadioButton).click();
    }
    //Function for choose Event type
    protected static WebElement SelectEvent = null;
    protected static WebElement EventType (WebDriver driver) {
        SelectEvent = driver.findElement(Constants.dropdownEvent);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        SelectEvent.click();
        return SelectEvent;
    }
    //Function for choosing specific Event type from the dropdown
    protected static WebElement EventID = null;
    protected static WebElement CurrentEventID (WebDriver driver){
        List<WebElement> AmountsList = driver.findElements(Constants.Choose_Event);
        AmountsList.get(3).click();
        return EventID;
    }
//Function for adding relevant test to all test area fields
    protected static void GiftTextFields(WebDriver driver) throws InterruptedException {
        Thread.sleep(Long.parseLong("3000"));
        driver.findElement(Constants.addressee).sendKeys("אמשלו");
        driver.findElement(Constants.sender).clear();
        driver.findElement(Constants.sender).sendKeys("בנשלה");
        driver.findElement(Constants.greeting).clear();
        driver.findElement(Constants.greeting).sendKeys("מזלט");
    }
    //Function for uploading a picture from the PC.
    protected static void UploadPic(WebDriver driver) throws InterruptedException {
        Thread.sleep(Long.parseLong("2000"));
        WebElement uploadElement = driver.findElement(Constants.uploadElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadElement);
        uploadElement.sendKeys("C:\\Users\\Michal\\Desktop\\picture.jpg");
    }
    //Function for testing the payment timing.
    protected static void When2PaySelector (WebDriver driver) throws InterruptedException {
        Thread.sleep(Long.parseLong("2000"));
        driver.findElement(Constants.PayLaterRadioButton).click();
        Thread.sleep(Long.parseLong("2000"));
        driver.findElement(Constants.payNowRadioButton).click();
    }
    //Function for adding Email to text field
    protected static void Where2SendGift (WebDriver driver){
        driver.findElement(Constants.sendByEmail).click();
        driver.findElement(Constants.insertEmail).sendKeys("headache@headache.com",Keys.ENTER);
    }
    //Function for submitting all input gift details
    protected static void SubmitGiftDetails(WebDriver driver) {
        driver.findElement(Constants.toPayment).click();
    }
}


