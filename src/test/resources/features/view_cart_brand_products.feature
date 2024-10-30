Feature: View & Cart Brand Products

  Background: User is already in the home page

  Scenario: User can view and navigate to different brand products
    When the user clicks on 'Products' button
    Then the 'Brands' section should be visible on the left sidebar
    When the user clicks on a brand name
    Then the user should be navigated to the selected brand page
    And brand products should be displayed
    When the user clicks on another brand link in the left sidebar
    Then the user should be navigated to the selected brand page
    And products from the new brand should be displayed
