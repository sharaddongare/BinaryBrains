@Twitter_Login1
Feature: Login page feature

  Scenario: Verify Twitter login functionality
    When user hits URL "https://twitter.com/"
    Then User clicks on Sign in button
    Then User enters 'valid_Email_ID'
    Then user enters valid Username and Password
    And click on login button
    Then user should close the browser




