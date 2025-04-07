package carrent.core;

import carrent.pages.AccountPage;
import carrent.pages.HomePage;
import carrent.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;
    public WebDriverWait wait;
    public BasePage basePage;
    public HomePage homePage;
    public LoginPage loginPage;

    public void init() {
        String browser = System.getProperty("browser", "safari");

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                WebDriverManager.edgedriver().setup();
                driver = new SafariDriver();
                break;
            default: // Это резервный сценарий на случай, если значение browser не совпадает ни с одним из указанных случаев
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        //driver = new ChromeDriver();
        driver.get("https://car-rental-cymg8.ondigitalocean.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // неявное
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // ожидание загрузки страницы
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        basePage = new BasePage(wait, driver);
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(wait, driver);
    }

    public BasePage getBasePage() {
        return basePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AccountPage getAccountPage() {
        return new AccountPage(wait, driver); // чтобы каждый раз был новый DOM
    }

    public void stop() {
        driver.quit();
    }

}
