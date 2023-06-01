# // Author: Camilla
Feature: Test header elements and functionality

  # // Author: Camilla
  Scenario: Verify that the header Home link navigates you to the right location
    Given User is on the page https://webshop-agil-testautomatiserare.netlify.app/
    When User clicks on Home link in the header
    Then The user should be navigated to the main page

  # // Author: Camilla
  Scenario: Verify that the header Shop link navigates you to the right location
    Given User is on the page https://webshop-agil-testautomatiserare.netlify.app/
    When User clicks on Shop link in the header
    Then The user should be navigated to the products page

    # // Author: Camilla
  Scenario: Verify that the website logo is visible
    Given User is on the page https://webshop-agil-testautomatiserare.netlify.app/
    Then The website logo should be visible

  Scenario: Verify that the checkout button in the header takes you to the right location
    Given User is on the page https://webshop-agil-testautomatiserare.netlify.app/
    When User clicks on the checkout button in the header
    Then The user should be navigated to the checkout page
