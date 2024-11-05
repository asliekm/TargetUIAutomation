@register
Feature: User Registration on Target.com

  Background: User is already on the home page
    Given User goes to Create an Account Page

  @posRegister
  Scenario: TC_01_US_01 Successful registration by using sign up with passkey option

    When the user fills out the registration form (by using sign up with passkey option)
    Then the user should be successfully registered

  @posRegister
  Scenario: TC_02_US_01 Successful registration by using sign up with password option

    When the user fills out the registration form (by using sign up with password option)
    Then the user should be successfully registered


  @negRegister
  Scenario: TC_03_US_01 Unsuccessful Registration with an invalid email

    When the user fills out the registration form with an invalid email
    Then the error message should be displayed as "Please enter your email"


  @negRegister
  Scenario: TC_04_US_01 Unsuccessful Registration with an already registered email

    When the user fills out the registration form with an already registered email
    Then the error message should be displayed with "That Target.com account already exists."


  @negRegister
  Scenario: TC_05_US_01 Unsuccessful Registration with weak password

    When the user fills out the registration form with weak password
    Then the error message should be displayed w "Please enter a valid password"
