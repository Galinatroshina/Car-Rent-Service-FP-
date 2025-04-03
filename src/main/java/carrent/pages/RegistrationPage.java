package carrent.pages;

import carrent.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(wait,driver);
    }

    @FindBy(css = "input[name='firstName']")
    WebElement userFirstName;
    @FindBy(css = "input[name='lastName']")
    WebElement userLastName;
    @FindBy(css = "input[name='email']")
    WebElement userEmail;
    @FindBy(css = "input[name='password']")
    WebElement userPassword;

    public RegistrationPage enterPersonalData(String firstName, String lastName, String email, String password) {
        type(userFirstName, firstName);
        type(userLastName, lastName);
        type(userEmail, email);
        type(userPassword, password);
        return this;
    }

    @FindBy (css = "input[type='checkbox']")
    WebElement termsCheckbox;

    public RegistrationPage agreeToTerms() {
    Actions actions = new Actions(driver);
    actions.moveToElement(termsCheckbox).click().perform();
        return this;
    }

    @FindBy (css = "button[type='submit']")
    WebElement createButton;

    public RegistrationPage clickCreateButton() {
        click(createButton);
        return this;
    }

    //* Sign Up
    @FindBy(xpath = "//a[normalize-space(text())='Sign up']")
    WebElement signUp;

    public void clickSignUp() {
        click(signUp);
        new RegistrationPage(driver, wait);
    }

    //* Check Successfully Registration
    @FindBy (xpath = "//button[normalize-space(text())='Log out']")
    WebElement logOut;

    public boolean checkLogOut() {
        return wait.until(ExpectedConditions.visibilityOf(logOut)).isDisplayed();
    }

    //* Check UnSuccessfully Registration
    @FindBy (xpath = "(//a[@data-discover='true'])[3]")
    WebElement logIn;

    public boolean checkLogIn() {
        return wait.until(ExpectedConditions.visibilityOf(logIn)).isDisplayed();
    }
}
