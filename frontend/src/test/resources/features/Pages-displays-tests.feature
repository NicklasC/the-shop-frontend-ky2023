Feature: Pages should display

  Scenario: Shop main page should show correct title
    Given user visits The Shop mainpage
    Then the browser title should be "Webbutiken"
