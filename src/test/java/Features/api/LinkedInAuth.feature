Feature: Post a message on LinkedIn

  @LinkedInAPI
  Scenario: User posts a message on LinkedIn
    Given User should have valid LinkedIn access token
    When User post a message on LinkedIn
    Then User message should be posted successfully

  @TwitterAPI
  Scenario: User twitt on message Twitter
    Then User should twitt on Twitter