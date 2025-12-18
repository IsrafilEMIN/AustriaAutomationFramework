Feature: Atlas Paint Offer Validation

  Scenario: User verifies the headline on the Offer Page
    Given the user is on the Atlas Paint homepage
    When the user navigates to the offers section
    Then the page headline should be "SPECIAL OFFERS"