Feature: log in

  Background:
    Given launch application

  Scenario Outline: Verifies user can login with valid credentials

    Given the user entered valid "<username>" and "<password>"
    When the user click on "Sign In" button
    Then user should be successfully logged in
    Examples:
      | username          | password   |
      | jacktest1@test.co | Tester123! |

  Scenario Outline:Verify user cannot login with "<invalidUsername>" and "<invalidPassword>"

    Given the user entered invalid "<invalidUsername>" and "<invalidPassword>"
    When the user click on "Sign In" button
    Then receives an error message
    Examples:
      | invalidUsername  | invalidPassword      |
      | notRealName      | notRealPassword      |
      | invalid pass     | johndoe@email.com    |
      | Password123      | doesNotExistUsername |
      | NotBlankPassword |                      |
      |                  | notBlankPassword     |
      |                  |                      |




