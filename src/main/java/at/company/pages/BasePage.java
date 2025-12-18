package at.company.pages;

import at.company.driver.DriverManager; // Import your Manager
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // CHANGED: No-Argument Constructor
    protected BasePage() {
        // 1. We grab the driver directly from the ThreadLocal
        this.driver = DriverManager.getDriver();

        // 2. We set up the wait using that driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ... (Keep your click, sendKeys, getText methods exactly the same)
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}