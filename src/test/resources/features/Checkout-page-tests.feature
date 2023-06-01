Feature: Test checkout page validation and functionality

  #TODO: This is a tutorial scenario, remove when suitable.
  # Author: Nicklas
  Scenario: Set username and verify it shows
    Given user set userName to "Nicklas"
    Then userName should be "Nicklas"

# Author: Nicklas
  Scenario: Add products to cart and verify sum is correct
    Given Visit The Shop Website
    When Click on the Shop tab
    And adding product with heading "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
    And adding product with heading "Mens Casual Premium Slim Fit T-Shirts"
    And adding product with heading "Mens Cotton Jacket"
    Then checkout badge text should be "3"
    And click on checkout button
    Then checkout form should display
    Then checkout badge text should be "3"
    Then cart size should be "3"
    And checkout total should be "$188"

# Author: Nicklas
  Scenario: Verify removing items from the cart
    Given Visit The Shop Website
    When Click on the Shop tab
    And adding product with heading "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
    And adding product with heading "Mens Casual Premium Slim Fit T-Shirts"
    And click on checkout button
    Then checkout form should display
    Then checkout badge text should be "2"
    Then cart size should be "2"
    And checkout total should be "$132"
    Then click the top remove button
    Then cart size should be "1"
    Then checkout badge text should be "1"
    And checkout total should be "$22"
