@searchproduct
Feature: Users should be able to search product
  Background: User is already in the home page

  Scenario Outline:  Verify search product functionality
    Given thw user able to click login button
    Then  the user able to see Login to your account
    When  the user write  username and password  then click login button
    Given  the user able to click product button then verify all items and all product visible
    Then the user should be able to enter the "<searched product>" in the search box and click the search button
    Then the user verifies that "<searched product>" is visible
    And all products related to the search are visible
    Examples:
    | searched product |
    | polo      |
