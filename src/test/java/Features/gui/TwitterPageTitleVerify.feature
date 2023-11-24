@Twitter_Pagetitle_Verify
Feature: Login page feature

  Scenario: Verify Twitter login page title
    Given User opens browser
    When user hits URL
    When user gets the title of the page
    Then page title should be "It’s what’s happening / X"
    Then user should close the browser





