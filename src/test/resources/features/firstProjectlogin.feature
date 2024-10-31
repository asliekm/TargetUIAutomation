@login
Feature: Users should be able to login

  Background: User is already in the home page


  Scenario: Verify login with valid crediantials
    Given thw user able to click login button
    Then  the user able to see Login to your account
    When  the user write  username and password  then click login button
    And   the user verify that logged in as username is visible