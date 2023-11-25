@EmailLogin
Feature: Login page feature

  Scenario: Verify Twitter login functionality
    Given User opens browser
    When user hits URL 'https://webmail.labcartscientific.com/Mondo/lang/sys/login.aspx'
    Then user enters emaild 'team11@labcartscientific.com' and Password '5y7aq46C#'
    Then user click on sign in button
    Then User clicks on Inbox
    Then Check for mail entries

#    Then User clicks on Sign in button
#    Then User enters 'valid_Email_ID'
#    Then user enters valid Username and Password
#    And click on login button
#    Then user should close the browser




