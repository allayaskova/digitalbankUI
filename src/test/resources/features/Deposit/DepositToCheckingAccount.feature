Feature: Deposit

  Scenario: Positive case. depositing funds to Checking Account
    Given launch application and login with login "johndoe@gmail.com" and password "Test123$"
    And the user has checking account with original balance
      | AccountForDeposit                        | Balance    |
      | John Doe First Account (Standard Checking) | 101000.00 |
    When the user deposits the following amount:
      | AccountForDeposit                        | depositAmount |
      | John Doe First Account (Standard Checking) | 1000.00       |
    Then the account balance should be updated as follows:
      | AccountForDeposit                        | NewBalance    |
      | John Doe First Account (Standard Checking) | 102000.00    |
