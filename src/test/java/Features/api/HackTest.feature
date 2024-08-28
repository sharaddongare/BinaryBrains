Feature: News API Interaction

#  @HackTest1
#  Scenario: Post news and validate
#    Given I have news data
#    When I validate the created item
#    Then the validation should be successful

  @HackApi1
  Scenario: Post news and validate
    Given I have news data
    When I post the news data to the API Server
    And Asserted item ID should be present in the response
    When Validate the created item using its ItemID from Server
