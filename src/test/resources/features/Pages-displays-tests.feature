Feature: Pages should display

  Scenario: Shop main page should show correct title
    Given user visits The Shop main page
    Then the browser title should be "Webbutiken"
