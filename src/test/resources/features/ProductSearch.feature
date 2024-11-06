@search
Feature: Display search results when entering a keyword in the search bar

  Background: User is already in the home page

  Scenario Outline: Displaying results when a keyword is entered in the search bar
    When the user enters "<keyword>" in the search bar
    And clicks on the search button
    Then the search results should display more than 0 results
    And the search results should contain the keyword "<keyword>"

    Examples:
      | keyword        |
      | christmas tree |
      | laptop         |
      | phone          |