Feature: Test main page elements and functionality

  # Author: Jim
  Scenario: Check that backpack image is displayed and heading is correct
    Given User is on main page
    Then Backpack image should be displayed
    And Heading should be "This shop is all you need"

    # Author: Jim
  Scenario: Check that the All products button navigates to the correct page
    Given User is still on main page
    When User clicks on the All products button
    Then User should be navigated to the products page