Feature: Test product page elements and functionality

  // Author: Priyanka

  Scenario: Validate click on Search Option
    Given Visit The Shop Website
    When Click on the Shop tab
    And Search the product
    Then Product should be displayed

    Scenario: Add product to cart
      Given Visit The Shop Website
      When Click on the Shop tab
      Then checkout button text should be empty or zero
      And adding product with heading "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
      Then checkout button text should be "1"
