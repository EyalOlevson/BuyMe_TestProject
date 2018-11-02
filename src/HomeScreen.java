import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeScreen {
    //Function for Clicking login and registration button.
    protected static void pressLogin(WebDriver driver) {
        driver.findElement(Constants.login).click();
    }
    //Function to select amount from dropdown.
    protected static WebElement SelectAmount = null;
    protected static WebElement ChooseAmount(WebDriver driver) {
        SelectAmount = driver.findElement(Constants.priceDropdown);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        SelectAmount.click();
        return SelectAmount;
    }
    //Function to select amount from dropdown.
    protected static WebElement Amount = null;
    protected static WebElement MyAmount (WebDriver driver){
        List<WebElement> AmountsList = driver.findElements(Constants.ChoosePrice);
        AmountsList.get(6).click();
        return Amount;
        }
        //Function for Click on search.
        protected static void SubmitSearch (WebDriver driver) throws InterruptedException {
            WebElement element = driver.findElement(Constants.submitsearch);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            driver.findElement(Constants.submitsearch).click();
        }
        //Function for choosing gifts
        protected static void ChooseGiftType (WebDriver driver)throws InterruptedException {
            WebElement element = driver.findElement(Constants.chooseGiftType);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            driver.findElement(Constants.chooseGiftType).click();
        }
    }
