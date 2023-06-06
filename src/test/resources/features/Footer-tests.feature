Feature: Test the links in the footer

  # Author: Daniel
  Scenario: Verify that the Home link works
    Given User is on the product page
    When User clicks on the Home link in the footer
    Then The headline on the page directed to should be "This shop is all you need"

  # Author: Daniel
  Scenario: Verify that the Shop link works
    Given User is on main page
    When When user clicks on the Shop link in the footer
    Then The url for the Shop page should be "https://webshop-team2.netlify.app/products.html"

  # Author: Daniel
  Scenario: Verify that the Checkout link works
    Given User is on main page
    When User clicks on the Checkout link in the footer
    Then The url for the Checkout page should be "https://webshop-team2.netlify.app/checkout.html"

  # Author: Daniel
  Scenario: Verify that the correct text is shown in the footers left part
    Given User is on main page
    Then The text in the footer should be "© 2023 The Shop"


