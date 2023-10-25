Feature: This feature file tests Profile page functionality
  Background:
    Given launch application

  Scenario: profile validation
    Given user login as "jacktest1@test.co" "Tester123!"
    When user clicks on my profile
    Then the user should see his or her account with the corresponding data:
      | title | firstName | lastName | homePhone  | mobilePhone | workPhone  | address    | locality | region | postalCode | country |
      | Mr.   | Jack      | Test     | 2146598800 | 2144598800  | 2146498800 | 12 Main St | City     | CA     | 99921      | US      |


