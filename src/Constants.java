import org.openqa.selenium.By;

public class Constants {
    //MainScreen
    public static final By login = By.className("my-account");
    public static final By priceDropdown = By.className("chosen-single");
    public static final By ChoosePrice = (By.className("active-result"));
    public static final By submitsearch = (By.xpath("//button[@type='submit']"));
    public static final By chooseGiftType = (By.partialLinkText("כניסה ל-10 משתתפים, 2 קבוצות מתחרות"));
    public static final By chooseGiftParameters = (By.partialLinkText("כניסה ל-3 משתתפים"));

    //RegistrationScreen
    public static final By registration = By.className("header-link");
    public static final By firstName = By.id("ember901");
    public static final By enterEmail = By.id("ember902");
    public static final By enterPassword  = By.id("valPass");
    public static final By validatePassword = By.id("ember904");
    public static final By regConsent = By.xpath("//label[@for='register-consent']");
    public static final By submitRegistration = By.xpath("//*[@id='ember900']/button");

    //GiftScreen
    public static final By giveGiftRadioButton = (By.xpath("//label[@data='forSomeone']"));
    public static final By forMyself = (By.xpath("//label[@data='forMyself']"));
    public static final By addressee = By.xpath("//input[@data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']");
    public static final By sender = By.xpath("//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']");
    public static final By greeting = (By.xpath("//textarea[@placeholder='מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים, עד 100 תווים']"));
    public static final By dropdownEvent = (By.xpath("//span[.='לאיזה אירוע?']")) ;
    public static final By Choose_Event = (By.className("active-result"));
    public static final By uploadElement = By.name("fileUploadדלגחנכדגלנכל");
    public static final By payNowRadioButton = (By.xpath("//label[.='מיד אחרי התשלום']")) ;
    public static final By PayLaterRadioButton = (By.xpath("//label[.='מאוחר יותר']")) ;
    public static final By sendByEmail = (By.xpath("//span[.='במייל']"));
    public static final By insertEmail = (By.xpath("//input[@type='email']"));
    public static final By toPayment =(By.xpath("//button[@data-toggle='modal']"));
}
