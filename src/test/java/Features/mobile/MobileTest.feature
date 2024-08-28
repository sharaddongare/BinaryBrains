@MobileTest1
Feature: Test Mobile

  Scenario: Get Product Details
    Given Setup Virtual MobileDriver
    Then Open Products
    Then Get Product Details for 3
    Then Close the App

