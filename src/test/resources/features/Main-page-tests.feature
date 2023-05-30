Feature: Test main page elements and functionality

  Scenario: Check that backpack image is displayed and heading is correct
    Given User is on main page
    Then Backpack image should be displayed
    And Heading should be "This shop is all you need"