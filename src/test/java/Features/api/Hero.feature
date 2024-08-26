@HeroCorp
Feature: Verfiy Hero Corp

  Scenario: Verfiy Hero Corp scenario
    Given I login to the application via API
    When I add 5 new contacts to the database
#   Then I verify the new contacts are added to the database
    And I remove the first 5 entries from the database

    When I add 5 new contacts to the database Test
    And I remove the first 5 entries from the database Test