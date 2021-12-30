Feature: Account Creation Test

  As a user I should be able to create account successfully

  @regression
  Scenario: verify user is able to create account successfully

    Given I click on sign in link
    When I enter email for create account
    And  I click on create new account button
    And I enter below details in the form
      | firstName | lastName | password  | address        | city     | state | postal | country | phone      |
      | Max     | Murphy    | passwrod10 | High street | New York | 1     | 123456  | 55      | 01234538475 |


    And I click on register button
    Then I verify account name "Max"

  @regression
  Scenario: verify user is not able to create account successfully using invalid data in form
    Given I click on sign in link
    When I enter email for create account
    And  I click on create new account button
    And I enter below details in the form
      | firstName | lastName | password | address | city    | state | postal         | country | phone   |
      | $$        | &&       |          |         | 16784567 | 1     | CODE | 20      | 19234533 |
    And I click on register button
    Then I verify the error message displayed which contains "errors"


