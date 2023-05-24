Feature: Test checkout page validation and functionality

  #TODO: This is a tutorial scenario, remove when suitable.
  Scenario: Set username and verify it shows
    Given user set userName to "Nicklas"
    Then userName should be "Nicklas"
