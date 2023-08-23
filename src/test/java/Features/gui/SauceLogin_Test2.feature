@MySanity
Feature: Login page validation for sauce

  @Sauce_Sanity1
  Scenario: Sauce Login verification
    Given User opens browser "firefox"
    When user hits URL "https://www.saucedemo.com/"
    Then user should enter valid username "standard_user" and password "secret_sauce" and click on login button

  @Sauce_Sanity2
  Scenario: Sauce Login page title verification
    Given user hits URL "https://www.saucedemo.com/"
    Then user should enter valid username "standard_user" and password "secret_sauce" and click on login button
    When user gets the title of the page
    Then page title should be "Swag Labs"

  @Sauce_Sanity3
  Scenario: Sauce add to cart verification
    Given user hits URL "https://www.saucedemo.com/"
    Then user should enter valid username "standard_user" and password "secret_sauce" and click on login button
    When user should perform add_to_cart and click on cart icon
    Then user proceed with checkout operation
    Then user should close the browser