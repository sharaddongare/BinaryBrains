Feature: News API Interaction

  @HackApi1
  Scenario: Post news and validate
    Given I have news data
    When I post the news data to the API Server
    And Asserted item ID should be present in the response
    When Validate the created item using its ItemID from Server
