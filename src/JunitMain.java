import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class JunitMain {
    private static WebDriver driver;

    @BeforeClass
    public static void runBefore() throws Exception {
        String browserType = ReadXML.getData("Browser");
        if (browserType.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Eyal's Automation Projects\\chromedriver_win32\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start--incognito");
            driver = new ChromeDriver(options);
        } else if (browserType.equals("IE")) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ReadXML.getData("URL"));
    }
//    extent.addSystemInfo("Enviroment","Production");
//    //log information into the report
//    test.log(LogStatus.INFO,"Connection driver","Before test method")
//}
    @Test //Test registration
    public void myTest01(){
        HomeScreen.pressLogin(driver);
        RegistrationScreen.ClickRegister(driver);
        RegistrationScreen.EnterName(driver);
        RegistrationScreen.EnterEmail(driver);
        RegistrationScreen.EnterPassword(driver);
        RegistrationScreen.ValidatePassword(driver);
        RegistrationScreen.RegConsent(driver);
        RegistrationScreen.SubmitRegistration(driver);
    }
    @Test //Test searching and choosing a gift
    public void myTest02() throws InterruptedException {
        Thread.sleep(1000);
        HomeScreen.ChooseAmount(driver);
        HomeScreen.MyAmount(driver);
        try {
            HomeScreen.SubmitSearch(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String url = driver.getCurrentUrl();
        try {
            HomeScreen.ChooseGiftType(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GiftScreen.RadioButtonSelector(driver);
        GiftScreen.GiftTextFields(driver);
        GiftScreen.EventType(driver);
        GiftScreen.CurrentEventID(driver);
    }
    @Test //Test the Radio buttons for when to pay
    public void myTest03() throws InterruptedException {
        GiftScreen.When2PaySelector(driver);
        GiftScreen.Where2SendGift(driver);
    }
    @Test //Test uploading image
        public void myTest04() throws InterruptedException {
            GiftScreen.UploadPic(driver);
        }
    @Test //Test submit button
    public void myTest05() {
        GiftScreen.SubmitGiftDetails(driver);
    }}

//@AfterClass
//public static void afterClass() {
////    end test and save data into report file
//    extent.endTesst(test);
//    extent.flush();
//    }
//}
