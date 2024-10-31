@product
Feature: Users should be
  Background: User is already in the home page

  Scenario: Verify All product and product detail
    Given thw user able to click login button
    Then  the user able to see Login to your account
    When  the user write  username and password  then click login button
    Given  the user able to click product button then verify all items and all product visible
    Then the user able to click on View Product of first product
    Then  the user should access to product detail page
    And  the user should verify  product name, category, price, availability, condition, brand are visible
