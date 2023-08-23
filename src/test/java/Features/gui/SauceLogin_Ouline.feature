@MySanity1
Feature: Login page validation for sauce

  Scenario Outline: Sauce add to cart verification
    Given User open the browser <Browser>
    Then user hits URL "https://www.saucedemo.com/"
    Then user should enter valid username "standard_user" and password "secret_sauce" and click on login button
    When user should perform add_to_cart and click on cart icon
    Then user proceed with checkout operation
    Then user should close the browser

    Examples:
      | Browser |
      | Chrome  |
      |firefox  |