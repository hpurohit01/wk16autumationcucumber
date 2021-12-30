Feature: Shopping cart test
  As a user I should be able to empty shopping cart successfully

   @regression
  Scenario: verify if user is able to empty the shopping cart
    Given I select menu "DRESSES"
    When I click on selected product "Printed Chiffon Dress"
    And I click on add to cart button
    And I click on proceed to checkout button
    And I verify product is added to shopping cart
    And I verify if delete button is available in shopping cart
    And I click on delete button
    Then I verify banner message "Your shopping cart is empty."