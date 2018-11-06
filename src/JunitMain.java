import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class JunitMain {

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

    private static ExtentReports extent;


    private static ExtentTest test;

    private static WebDriver driver;

    @Rule
    public TestName SS = new TestName();


    @BeforeClass
    public static void runBefore() throws Exception {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\Michal\\Desktop\\ReportsFilePath\\extent.html");


        htmlReporter.setAppendExisting(true);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        test = extent.createTest("@BeforeClass", "Loading BuyMe page");

        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Eyal");


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
        test.log(Status.INFO,"connecting driver");
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
        test.log(Status.INFO,"connecting driver");
        GiftScreen.When2PaySelector(driver);
        GiftScreen.Where2SendGift(driver);
    }
    @Test //Test uploading image
        public void myTest04() throws InterruptedException {
        test.log(Status.INFO,"connecting driver");
        GiftScreen.UploadPic(driver);
        }
    @Test //Test submit button
    public void myTest05() {
        test.log(Status.INFO,"connecting driver");
        GiftScreen.SubmitGiftDetails(driver);
    }

@AfterClass
public static void afterClass() {
//    end test and save data into report file
    extent.flush();
    driver.close();
    }
}
