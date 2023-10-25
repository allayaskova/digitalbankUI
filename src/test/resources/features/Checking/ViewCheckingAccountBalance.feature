Feature: View checking account balance
Scenario: View checking account balance
  Given user is on login with credentials "johndoe@gmail.com" and password "Test123$"
And user has a checking account with the following details:
| Account Number | Balance   |
| 486131696    | $1025    |
When user checks the account balance
Then user should see the following account details:
| Account Number | Balance   |
| 486131696       | $1025    |