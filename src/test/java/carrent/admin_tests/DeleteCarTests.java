package carrent.admin_tests;

import carrent.admin_pages.AdminPage;
import carrent.admin_pages.CarsPage;
import carrent.core.TestBase;
import carrent.pages.HomePage;
import carrent.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeleteCarTests extends TestBase {

    @BeforeEach
    public void setUp() {
        new HomePage(app.driver, app.wait).selectLogin();
        new LoginPage(app.driver, app.wait).adminLogIn("admin@gmail.com", "Yyyyyyy12345!");
    }

    @ParameterizedTest
    @ValueSource (strings = {"Honda Civic", "Nissan Altima", "Hyundai Santa fe", "Kia Sportage"})
    public void deleteCarFromDataBasePositiveTest(String carName) {
        CarsPage carsPage = new AdminPage(app.driver, app.wait)
                .enterToTheAdminPanel()
                .enterToTheCarsPage();
        carsPage
                .deleteCar()
                .verifyAndConfirmAlert("The car is deleted");
        boolean isCarPresent = carsPage.isCarPresent(carName);
        assertFalse(isCarPresent, "The car should be deleted but is still present");
    }
}
