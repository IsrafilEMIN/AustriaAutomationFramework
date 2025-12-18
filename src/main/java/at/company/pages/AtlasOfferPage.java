package at.company.pages;

import org.openqa.selenium.By;

public class AtlasOfferPage extends BasePage {

    // --- Locators ---
    private final By offerLink = By.partialLinkText("Book a Call");
    private final By offerPageH1 = By.tagName("h1");
    private final By offerPageH3 = By.tagName("h3");

    public String getHeadlineText() {
        return getText(driver.findElement(offerLink));
    }

    public String getHeadline1Text() {
        return getText(driver.findElement(offerPageH1));
    }

    public String getHeadline3Text() {
        return getText(driver.findElement(offerPageH3));
    }

    public void clickOfferLink() {
        driver.findElement(offerLink).click();
    }
}