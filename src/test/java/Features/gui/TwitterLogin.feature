@Twitter_Login
Feature: Login page feature

  Scenario Outline: Verify Twitter login functionality
    Given User open the browser <Browser>
    When user hits URL "https://twitter.com/"
    Then User clicks on Sign in button
    Then User enters valid Email ID
    Then user enters valid Username and Password
    And click on login button
    Then user should close the browser

    Examples:
      | Browser |
      | Chrome  |
      |firefox  |



