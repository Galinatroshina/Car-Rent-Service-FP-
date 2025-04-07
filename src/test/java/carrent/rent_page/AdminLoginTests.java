package carrent.rent_page;

import carrent.core.TestBase;
import carrent.pages.AdminPage;
import carrent.pages.HomePage;
import carrent.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class AdminLoginTests extends TestBase {

    @BeforeEach
    public void setUp() {
        new HomePage(app.driver, app.wait).selectLogin();
    }

    @Test
    public void testAdminAuthorizationPositiveTest() {
        // Переходим на страницу логина
        LoginPage loginPage = app.getLoginPage();
        loginPage.enterEmail("admin@gmail.com");
        loginPage.enterPassword("Yyyyyyy12345!");
        loginPage.clickLoginButton();
        // Проверяем видимость элемента "My Account"
        AdminPage adminPage = app.getAdminPage(); // получаем новую версию после логина
        assertTrue("The 'My Account' element is visible", adminPage.isMyAccountVisible());
        shouldRunTearDown = false;

    }

    @Test
    public void testAdminAuthorizationEmptyEmailNegativeTest() {
        // Переходим на страницу логина
        LoginPage loginPage = app.getLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("Yyyyyyy12345!");
        loginPage.clickLoginButton();
        // Проверяем, что элемент "Admin" не виден
        AdminPage adminPage = app.getAdminPage();
        assertFalse( "The 'Admin' element is visible with incorrect email", adminPage.isMyAccountVisible());
        shouldRunTearDown = false;
    }

    @Test
    public void testAdminAuthorizationEmptyPasswordNegativeTest() {
        // Переходим на страницу логина
        LoginPage loginPage = app.getLoginPage();
        loginPage.enterEmail("admin@gmail.com");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        // Проверяем, что элемент "Admin" не виден
        AdminPage adminPage = app.getAdminPage();
        assertFalse( "The 'Admin' element is visible with incorrect password", adminPage.isMyAccountVisible());
        shouldRunTearDown = false;
    }

    @Test
    public void testAdminAuthorizationInvalidCredentialsNegativeTest() {
        // Переходим на страницу логина
        LoginPage loginPage = app.getLoginPage();
        loginPage.enterEmail("admi@gmail.com");
        loginPage.enterPassword("Yyyyyyy12345!");
        loginPage.clickLoginButton();
        // Проверяем, что элемент "Admin" не виден
        AdminPage adminPage = app.getAdminPage();
        // Check interface
        assertFalse( "The 'My Account' element is visible with incorrect credentials", adminPage.isMyAccountVisible());
        // Check error message
        String expectedMessage = "Password or email incorrect";
        String actualMessage = app.getLoginPage().getErrorMessage();
        assertEquals(expectedMessage, actualMessage, "Error message should match expected text for invalid login");
        shouldRunTearDown = false;
    }

    @AfterEach
    public void tearDown() {
        app.stop();
    }
}
