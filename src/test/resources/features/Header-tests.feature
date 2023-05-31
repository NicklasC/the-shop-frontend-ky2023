# // Author: Camilla
Feature: Test header elements and functionality

  Scenario: Verify that the header Home link navigates you to the right location
    Given User is on the page https://webshop-agil-testautomatiserare.netlify.app/
    When User clicks on Home link in the header
    Then User should be navigated to the main page

  Scenario: Verify that the header Shop link navigates you to the right location
    Given User is on the page https://webshop-agil-testautomatiserare.netlify.app/
    When User clicks on Shop link in the header
    Then User should be navigated to the products page