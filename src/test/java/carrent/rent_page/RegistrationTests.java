package carrent.rent_page;

import carrent.core.TestBase;
import carrent.pages.HomePage;
import carrent.pages.RegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).selectLogin();
        new RegistrationPage(app.driver, app.wait).clickSignUp();
    }

    @Test
    public void registrationPositiveTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "test_123456@gmail.com", "Password1@")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogOut();
    }

    @Test
    public void registrationNegativeAlreadyExistTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "test_1234@gmail.com", "Password1@")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogIn();
    }

    @Test
    public void registrationNegativeInvalidEmailTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "test-gmail", "Password1@")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogIn();
    }

    @Test
    public void registrationNegativeInvalidPasswordTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "test_12345@gmail.com", "Password@")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogIn();
    }

    @Test
    public void registrationNegativeInvalidFirstNameTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("", "Snow", "test_123456@gmail.com", "Password@")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogIn();
    }

    @Test
    public void registrationNegativeInvalidLastNameTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "", "test_123457@gmail.com", "Password@")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogIn();
    }

    @Test
    public void registrationNegativeEmptyEmailTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "", "Password@")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogIn();
    }

    @Test
    public void registrationNegativeEmptyPasswordTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "test_123458@gmail.com", "")
                .agreeToTerms()
                .clickCreateButton()
                .checkLogIn();
    }


    @AfterMethod (enabled = false)
    public void postcondition() {
        app.driver.close();
    }
}
