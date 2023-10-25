Feature: Remember me button
  Scenario: user clicks on remember me button
    Given the user is on main page with url "https://dbank-qa.wedevx.co/bank/login"
    When the user fills out his credentials "johndoe@gmail.com" and "Test123$"
    And the user clicks on "Remember Me" button
    Then the user click Sign In button and credentials should be saved