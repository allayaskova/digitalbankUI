Feature: Create a new savings account

  Scenario: Create a new standard individual saving account
    Given url "https://dbank-qa.wedevx.co/bank/login" is opened
    And User enters userName "johndoe@gmail.com" and password "Test123$"
    And creates a new individual savings account with the following data
      | accountName           | accountType       | ownership  | deposit   |
      | John Doe First Savings | Savings | Individual | 1000.00 |
    Then User should see a green confirmation message saying "Confirmation Successfully created new Savings account named John Doe First Savings Account"
    And User should see the new checking account card
      | accountName           | accountType       | ownership  | accountNumber | interestRate | balance   |
      | John Doe First Savings | Savings | Individual | 486132532     | 1.85%         | 1000.00 |
    And User should see the following Transaction menu
      | date             | category | description               | amount    | balance   |
      | 2023-09-28 22:52 | Income   | 845323487 (DPT) - Deposit | 1000.00 | 1000.00 |


