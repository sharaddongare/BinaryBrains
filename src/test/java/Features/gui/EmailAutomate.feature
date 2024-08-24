@EmailAutomate
Feature: Automate sending an email

  @EmailTest
  Scenario: Send an email
    Given User opens browser
    When user hits URL
    Then user enters valid Username and Password for goDaddy

