package at.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AtlasOfferPage extends BasePage {

    // 1. Parameterized Constructor
    // We must pass the driver up to the BasePage (Parent)
    public AtlasOfferPage(WebDriver driver) {
        super(driver);
    }

    // --- 2. Locators ---
    // Update these specific strings based on what you see when you Inspect your site!

    // Example: The link in the navigation menu to go to Offers/Catalog
    // I am using partialLinkText because it's flexible (e.g., matches "Catalog" or "Full Catalog")
    private final By catalogLink = By.partialLinkText("Catalog");

    // Example: The big header text on the destination page (usually an <h1> tag)
    private final By pageHeadline = By.tagName("h1");

    // --- 3. Actions ---

    public void clickCatalogLink() {
        // We use the 'click' method from BasePage which has the built-in wait
        click(driver.findElement(catalogLink));
    }

    public String getHeadlineText() {
        // We use the 'getText' method from BasePage
        return getText(driver.findElement(pageHeadline));
    }
}