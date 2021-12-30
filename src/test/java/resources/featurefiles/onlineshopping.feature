Feature: SignUp SignIn and Purchase Product
  As a user I should be able to signup signin and purchase product.

  @practice
  Scenario: TC-001 Create New User signup
    Given I am on home page
    Given I click on sign in link
    When I enter email for create account
    And  I click on create new account button
    And I fill the form using one method
    And I click on register button
    Then I verify account name "Max"

  @practice
  Scenario: TC-002 Sign In with newly created user credentials
    Given I click on sign in link
    When I login using newly created credentials
    Then I shall verify the address information in my address section

