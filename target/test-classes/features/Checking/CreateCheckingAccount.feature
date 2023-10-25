Feature: Create a new checking account

  Scenario: Create a new standard individual checking account
    Given url "https://dbank-qa.wedevx.co/bank/login" is opened
    And User enters userName "johndoe@gmail.com" and password "Test123$"
    And creates a new individual checking account with the following data
      | accountName           | accountType       | ownership  | deposit   |
      | John Doe First Checking | Standard Checking | Individual | 100000.00 |
    Then User should see a green confirmation message saying "Successfully created new Standard Checking"
    And User should see the new checking account card
      | accountName           | accountType       | ownership  | accountNumber | interestRate | balance   |
      | John Doe First Checking | Standard Checking | Individual | 486131225     | 0.0%         | 100000.00 |
    And User should see the following Transaction menu
      | date             | category | description               | amount    | balance   |
      | 2023-09-07 21:19 | Income   | 845321935 (DPT) - Deposit | 100000.00 | 100000.00 |





