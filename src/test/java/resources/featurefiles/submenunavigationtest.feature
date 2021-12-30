Feature: Sub Menu Navigation Test
  As a user I should be able to navigate to submenu page

  @regression
  Scenario: verify user is able to navigate to Summer Dresses page
    Given I hover mouse to "WOMEN"
    When I hover mouse and click on submenu "Summer Dresses"
    Then  I verify if heading of page is "SUMMER DRESSES"

   @regression
  Scenario: verify user is able to filter price change and see the change in search results
    And I change the price range on slider of max price to "20.00"
    Then I verify if search results are priced withing the max price range "20.00"