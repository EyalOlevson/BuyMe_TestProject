import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class JunitMain {
    private static WebDriver driver;
    @BeforeClass

    public static void runBefore () throws Exception {
        String browserType = getData ("Browser");
        if(browserType.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Eyal's Automation Projects\\chromedriver_win32\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start--incognito");
            driver = new ChromeDriver(options);
        }else if(browserType.equals("IE")){
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getData("URL"));
    }
    public static String getData (String keyName) throws Exception{
        File configXmlFile=new File("C:\\Users\\Michal\\Desktop\\Config2.xml");
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
        Document doc=dBuilder.parse(configXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
//        System.setProperty("webdriver.chrome.driver", "C:\\Eyal's Automation Projects\\chromedriver_win32\\chromedriver.exe");
        //new NgWebDriver((JavascriptExecutor)driver).waitForAngularRequestsToFinish();

//        static ChromeOptions options = new ChromeOptions();
//        options.addArguments("-incognito");
//        options.addArguments("start--incognito");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://buyme.co.il");

    @Test
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
    @Test
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
    @Test
    public void myTest03() throws InterruptedException {
        GiftScreen.When2PaySelector(driver);
        GiftScreen.Where2SendGift(driver);
    }
    @Test
        public void myTest04() throws InterruptedException {
            GiftScreen.UploadPic(driver);
        }
    @Test
    public void myTest05(){
    GiftScreen.SubmitGiftDetails(driver);
    }
}
