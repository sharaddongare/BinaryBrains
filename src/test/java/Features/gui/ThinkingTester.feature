@Mock
Feature: Login page feature

  Scenario: Verify Twitter login functionality
    Given User open the browser 'Chrome'
    When user hits URL 'http://thinking-tester-contact-list.herokuapp.com/'
    Then User Cliks on singIn Button
    Then User enter singin data 'sharad''dongare''Password134''sharaaaaasaqd@abc.com'
    Then User enters firstName 'sharad' and Lastname 'Dongare'
    Then User enter singin data 'Rushi''Dafal''Password134''rushi@abc.com'
    Then User enters firstName 'Rushi' and Lastname 'Dafal'
    Then User enter singin data 'pradip''dongare''Password134''pradip@abc.com'
    Then User enters firstName 'sunil' and Lastname 'Dongare'
    Then User enter singin data 'Suni''dongare''Password134''Suni@abc.com'
    Then User enters firstName 'suni' and Lastname 'Dongare'
    Then User enter singin data 'Suni''dongare''Password134''test@abc.com'
    Then User enters firstName 'Suni' and Lastname 'Dongare'


