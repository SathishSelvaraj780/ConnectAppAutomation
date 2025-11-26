Feature: Login to Connect App

  Scenario: User logs in with valid credentials
    Given user launches the Connect app
    When user enters valid username and password
    Then user should be logged in successfully