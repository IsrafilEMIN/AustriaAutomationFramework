package at.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    // Protected so child pages (LoginPage, etc.) can access them directly
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Parameterized Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Automatically set up an explicit wait of 10 seconds for all pages
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --- Wrapper Methods for Efficiency ---

    // 1. Click with Wait
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // 2. Type with Wait
    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear(); // Good practice to clear before typing
        element.sendKeys(text);
    }

    // 3. Get Text with Wait
    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}