Feature: Login page feature

  @Mytag
Scenario: Login page title
Given User opens browser "Chrome"
    When user hits URL "Test1"
When user gets the title of the page
Then page title should be "IngParaBanking"