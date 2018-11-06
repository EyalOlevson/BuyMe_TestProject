import org.openqa.selenium.WebDriver;

//Function for Clicking registration button.
public class RegistrationScreen {
    protected static void ClickRegister(WebDriver driver) {
        driver.findElement(Constants.registration).click();
    }
    //Function for submitting test in first name field
    protected static void EnterName(WebDriver driver) {
        driver.findElement(Constants.firstName).sendKeys("pooki");
    }
    //Function for submitting test in email field
    protected static void EnterEmail(WebDriver driver) {
        driver.findElement(Constants.enterEmail).sendKeys("pooki@pookipookii35.com");
    }
    //Function for submitting test in Password field
    protected static void EnterPassword (WebDriver driver) {
        driver.findElement(Constants.enterPassword).sendKeys("Pookipooki1");
    }
    //Function for submitting passoword in the validating password field
    protected static void ValidatePassword (WebDriver driver){
        driver.findElement(Constants.validatePassword).sendKeys("Pookipooki1");

    }
    //Function for submitting registration details
    protected static void RegConsent (WebDriver driver) {
        driver.findElement(Constants.regConsent).click();
    }
    protected static void SubmitRegistration (WebDriver driver) {
        driver.findElement(Constants.submitRegistration).click();
    }
}
