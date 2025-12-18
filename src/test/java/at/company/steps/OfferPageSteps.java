package at.company.steps;

import at.company.driver.DriverManager;
import at.company.pages.AtlasOfferPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OfferPageSteps {

    // We don't initialize it yet. We do it inside the method.
    AtlasOfferPage offerPage =  new AtlasOfferPage();

    @Given("the user is on the Atlas Paint homepage")
    public void userOnHomePage() {
        String title = offerPage.getHeadlineText();
        Assert.assertTrue(title.contains("Book a Call"), "Not on Atlas Offer Page!");
    }

    @When("the user navigates to the offers section")
    public void userNavigatesToOffers() {
        offerPage.clickOfferLink();
        Assert.assertTrue(offerPage.getHeadline1Text().equalsIgnoreCase("Homeowner's Trusted Painter"));
    }

    @Then("the page headline should be {string}")
    public void verifyHeadline(String expectedHeadline) {
        String actualHeadline = offerPage.getHeadline1Text();
        // We use ignoring case because CSS usually capitalizes text
        Assert.assertTrue(actualHeadline.equalsIgnoreCase(expectedHeadline),
                "Headline mismatch! Expected: " + expectedHeadline + ", Found: " + actualHeadline);
    }
}