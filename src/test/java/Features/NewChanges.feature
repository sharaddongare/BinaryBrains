Feature: Login page feature

  @Mytaggg
Scenario: Login page title
Given User opens browser "Chrome"
    When user hits URL "https://www.saucedemo.com/"
When user gets the title of the page
Then page title should be "Swag Labs"