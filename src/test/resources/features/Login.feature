@wip  @login
Feature: User Login on Target.com

  Background: User is already in the home page
    Given the user goes to Sign In Page

@positiveLogin
  Scenario: TC_01_US_O2 Succesful Login with valid credentials

    Then the user enters "aValidUsername"
    And the user enters a valid password
    When the user clicks on "Sign In" button
    Then the user should be able to see My Target Button on the Sign In Bar
    ## And the user is able to see "Sign Out" option

@negativeLogin
  Scenario: TC_02_US_02 Attempt login with an invalid username

    Then the user enters an invalid username
    And the user enters a valid password
    When the user clicks on "Sign In" button
    Then error message should be displayed saying "We can't find your account."

@negativeLogin
  Scenario: TC_03_US_02 Attempt login with an invalid password

    Then the user enters "aValidUsername"
    And the user enters an invalid password
    When the user clicks on "Sign In" button
    Then th error message should be displayed saying "please enter a valid password"

  @negativeLogin
  Scenario: TC_04_US02 Attempt login with invalid username and password

    Then the user enters an invalid username
    And the user enters an invalid password
    When the user clicks on "Sign In" button
    Then th error message should be displayed saying "Please enter your password"

@negativeLogin
  Scenario: TC_05_US02 Attempt login with an empty email and password fields

    Then the user enters an empty username
    And the user enters an empty password
    When the user clicks on "Sign In" button
    Then th error message should be displayed saying "Please enter your password"

@negativeLogin
  Scenario: TC_06_US_02 Attempt login with a valid username and a blank password

    Then the user enters "aValidUsername"
    And the user enters a blank password
    When the user clicks on "Sign In" button
    Then th error message should be displayed saying "Please enter your password"
