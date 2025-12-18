package at.company.steps;

import at.company.driver.DriverManager;
import at.company.pages.AtlasOfferPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OfferPageSteps {

    // We don't initialize it yet. We do it inside the method.
    AtlasOfferPage offerPage;

    @Given("the user is on the Atlas Paint homepage")
    public void userOnHomePage() {
        // Hooks class already opened the browser and went to the URL
        // So we just verify we are there
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(title.contains("Homeowner's Trusted Painter"), "Not on Atlas Offer Page!");
    }

    @When("the user navigates to the offers section")
    public void userNavigatesToOffers() {
        offerPage.clickOfferLink();
        Assert.assertTrue(offerPage.getHeadline1Text().equalsIgnoreCase("Homeowner's Trusted Painter"));
    }

    @Then("the page headline should be {string}")
    public void verifyHeadline(String expectedHeadline) {
        String actualHeadline = offerPage.getHeadline3Text();
        // We use ignoring case because CSS usually capitalizes text
        Assert.assertTrue(actualHeadline.equalsIgnoreCase(expectedHeadline),
                "Headline mismatch! Expected: " + expectedHeadline + ", Found: " + actualHeadline);
    }
}