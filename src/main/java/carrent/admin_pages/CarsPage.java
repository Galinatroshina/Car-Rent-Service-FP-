package carrent.admin_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsPage extends AdminPage {
    public CarsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "(//button[@type='button'])[3]")
    WebElement deleteButton;
    public CarsPage deleteCar() {
        deleteButton.click();
        return this;
    }

    public CarsPage verifyAndConfirmAlert(String expectedMessage) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = alert.getText();
        assertTrue(actualMessage.contains(expectedMessage), "Alert should contain expected message");
        alert.accept();
        return this;
    }

    @FindBy (xpath = "(//div[contains(@class,'flex-1 min-w-0')])[1]")
    WebElement carField;
    public boolean isCarPresent(String carName) {
        try {
            return carField.isDisplayed();  // Проверяем, отображается ли элемент
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;  // Если элемент не найден или не видим
        }
    }
}
