Feature: Test product page elements and functionality

  # Author: Priyanka
  Scenario: Validate click on Search Option
    Given Visit The Shop Website
    When Click on the Shop tab
    And Search the product
    Then Product should be displayed

  # Author: Nicklas
  Scenario: Add product to cart
    Given Visit The Shop Website
    When Click on the Shop tab
    Then checkout badge text should be empty or zero
    And adding product with heading "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
    Then checkout badge text should be "1"

  # Author: Priyanka
  Scenario: Validate click on All Tab
    Given Visit The Shop Website
    When Click on the Shop tab
    And Click on All tab
    Then Product should be displayed

  # Author: Priyanka
  Scenario: Validate click on Men's Clothing Tab
    Given Visit The Shop Website
    When Click on the Shop tab
    And Click on Men's Clothing tab
    Then Men's Product should be displayed