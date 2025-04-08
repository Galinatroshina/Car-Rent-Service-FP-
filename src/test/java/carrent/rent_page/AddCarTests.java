package carrent.rent_page;

import carrent.core.TestBase;
import carrent.pages.HomePage;
import carrent.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddCarTests extends TestBase {
    @BeforeEach
    public void setUp() {
        new HomePage(app.driver, app.wait).selectLogin();
        new LoginPage(app.driver, app.wait).adminLogIn("admin@gmail.com", "Yyyyyyy12345!");
    }
}
