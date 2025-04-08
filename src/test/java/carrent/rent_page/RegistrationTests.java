package carrent.rent_page;

import carrent.core.TestBase;
import carrent.pages.HomePage;
import carrent.pages.RegistrationPage;
import carrent.utils.DataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests extends TestBase {

    @BeforeEach
    public void setUp() {
        new HomePage(app.driver, app.wait).selectLogin();
        new RegistrationPage(app.driver, app.wait).clickSignUp();
    }

    @Test
    public void registrationPositiveTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "johnsnow5_test1@gmail.com", "Password1@")
                .agreeToTerms()
                .clickCreateButton()
                .verifySuccessMessage("Registration successful! Please check your email to confirm your registration.")
                .clickOkButton();

    }


    @Test
    public void registrationNegativeAlreadyExistTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "test_1234@gmail.com", "Password1@")
                .agreeToTerms()
                .clickCreateButton()
                .verifyErrorMessage("Error")
                .clickCancelButton();
    }

    @Test
    public void registrationWithInvalidEmailNegativeTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "test43gmail.com", "Password1@")
                .agreeToTerms()
                .clickCreateButton();
        // Проверяем видимость элемента "Log In"
        RegistrationPage registrationPage = app.getRegistrationPage();
        assertTrue(registrationPage.isLogInVisible(), "The 'Log In' element is visible");
        shouldRunTearDown = false;
    }

    @Test
    public void registrationWithInvalidPasswordNegativeTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "johnsnow"+System.currentTimeMillis()+"@gmail.com", "Password@")
                .agreeToTerms()
                .clickCreateButton();
        RegistrationPage registrationPage = app.getRegistrationPage();
        assertTrue(registrationPage.isPasswordMessageVisible());
        shouldRunTearDown = false;
    }

    @Test
    public void registrationWithInvalidLittlePasswordNegativeTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("John", "Snow", "johnsnow"+System.currentTimeMillis()+"@gmail.com", " Pass@1")
                .agreeToTerms()
                .clickCreateButton();
        RegistrationPage registrationPage = app.getRegistrationPage();
        assertTrue(registrationPage.isLittlePasswordMessageVisible());
        shouldRunTearDown = false;
    }

    @Test
    public void registrationNegativeInvalidFirstNameTest() {
        new RegistrationPage(app.driver, app.wait)
                .enterPersonalData("", "Snow", "test_123456@gmail.com", "Password@")
                .agreeToTerms();
        RegistrationPage registrationPage = app.getRegistrationPage();
        assertFalse(registrationPage.isCreateButtonEnabled(), "The 'Create' button should be inactive if the field is empty.");
        shouldRunTearDown = false;

    }

    @Test
    public void registrationInvalidLastNameNegativeTest() {
        RegistrationPage registrationPage = new RegistrationPage(app.driver, app.wait);
        registrationPage
                .enterPersonalData("John", "", "test_123457@gmail.com", "Password@")
                .agreeToTerms();
        assertFalse(registrationPage.isCreateButtonEnabled(), "The 'Create' button should be inactive if the field is empty.");
        shouldRunTearDown = false;
    }

    @Test
    public void registrationEmptyEmailNegativeTest() {
        RegistrationPage registrationPage = new RegistrationPage(app.driver, app.wait);
        registrationPage
                .enterPersonalData("John", "Snow", "", "Password@")
                .agreeToTerms();
        assertFalse(registrationPage.isCreateButtonEnabled(), "The 'Create' button should be inactive if the field is empty.");
        shouldRunTearDown = false;
    }

    @Test
    public void registrationEmptyPasswordNegativeTest() {
        RegistrationPage registrationPage = new RegistrationPage(app.driver, app.wait);
        registrationPage
                .enterPersonalData("John", "Snow", "test_123458@gmail.com", "")
                .agreeToTerms();
        assertFalse(registrationPage.isCreateButtonEnabled(), "The 'Create' button should be inactive if the field is empty.");
        shouldRunTearDown = false;
    }
}