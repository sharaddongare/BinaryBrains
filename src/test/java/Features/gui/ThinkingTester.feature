@Mock
Feature: Login page feature

  Scenario: Verify Twitter login functionality
    Given User open the browser 'Chrome'
    When user hits URL 'http://thinking-tester-contact-list.herokuapp.com/'
    Then User Cliks on singIn Button
    Then User enter singin data 'sharad''dongare''Password134''sharaasaqd@abc.com'
    Then User enters firstName 'sharad' and Lastname 'Dongare'


