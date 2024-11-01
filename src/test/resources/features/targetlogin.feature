@wip
Feature: Users should be able to login

  Background: User is already in the home page


  Scenario: Verify login with valid crediantials on Target Page
    Given the user is able to click signin button on home page
    Then the user is able to click signin button on Signin Bar
    And the user is able to write email and password then click Signin with password button
    And the user is able to see Add mobile phone option on the page
    When the user is able to click Skip button
    And the user is able too see Let's simplify your next sign-in script
    And the user clicks Maybe later button
    And the user is able to see Ship to button on main page

