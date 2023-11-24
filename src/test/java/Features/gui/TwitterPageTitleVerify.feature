@Twitter_Pagetitle_Verify
Feature: Login page feature

  Scenario: Verify Twitter login page title
    Given User opens browser "Chrome"
    When user hits URL
    When user gets the title of the page
    Then page title should be "It’s what’s happening / X"
    Then User clicks on Sign in button
    Then user enters valid Username and Password
    When When user enter a post "Hi Tweet we found your defect"
    Then user should close the browser






