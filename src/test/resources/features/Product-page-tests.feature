Feature: Test product page elements and functionality

  // Author: Priyanka
  Scenario: Validate click on Search Option
    Given Visit The Shop Website
    When Click on the Shop tab
    And Search the product
    Then Product should be displayed

  Scenario: Validate click on Men's Clothing Tab
    Given Visit The Shop Website
    When Click on the Shop tab
    And Click on Men's Clothing tab
    Then Product should be displayed