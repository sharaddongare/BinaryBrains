Feature: Post a message on LinkedIn

  @LinkedInAPI
  Scenario: User posts a message on LinkedIn
    Given User should have valid LinkedIn access token
    When User post a message on LinkedIn
    Then User message should be posted successfully

#    @Hero1
#    Scenario: Test
#      Given I login to the application via API


