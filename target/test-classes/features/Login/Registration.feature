@Registration
Feature: Registration

  Scenario: Positive case. Successful creation of DBank account
    Given the following user with email "jacktest1@test.co" is not in DB
    And the user navigates to signup page
    When the user creates account with following fields
      | title | firstName | lastName | gender | DOB        | SSN         | email             | password   | confirmPassword | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | agreeToTermsCheckBox |
      | Mr.   | Jack      | Test     | M      | 12/12/1991 | 123-44-2236 | jacktest1@test.co | Tester123! | Tester123!      | 12 Main St | City     | CA     | 99921      | US      | 2146598800 | 2144598800  | 2146498800 | true                 |
    Then the user should be displayed with the message "Success Registration Successful. Please Login."
    Then the user info should be saved in the db
      | title | firstName | lastName | gender | DOB        | SSN         | email             | password   | confirmPassword | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | agreeToTermsCheckBox | accountNonExpired | accountNonLocked | credentialsNonExpired | enabled |
      | Mr.   | Jack      | Test     | M      | 12/12/1991 | 123-44-2236 | jacktest1@test.co | Tester123! | Tester123!      | 12 Main St | City     | CA     | 99921      | US      | 2146598800 | 2144598800  | 2146498800 | true                 | true              | true             | true                  | true    |

  @NegativeRegistrationCase
  Scenario Outline: Negative case. No ability to register with empty data
    Given the user navigates to signup page
    When the user creates account with following fields
      | title   | firstName   | lastName   | gender   | DOB   | SSN   | email   | password   | confirmPassword   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | agreeToTermsCheckBox |
      | <title> | <firstName> | <lastName> | <gender> | <DOB> | <SSN> | <email> | <password> | <confirmPassword> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <true>               |
    Then the user should see the "<fieldError>" required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | DOB        | SSN         | email            | password | confirmPassword | address      | locality         | region | postalCode | country       | homePhone    | mobilePhone  | workPhone    | agreeToTermsCheckBox | fieldError           | errorMessage                                                             |
      |       |           |          |        |            |             |                  |          |                 |              |                  |        |            |               |              |              |              |                      | title                | Please select an item in the list.                                       |
      | Mr.   |           |          |        |            |             |                  |          |                 |              |                  |        |            |               |              |              |              |                      | firstName            | Please fill out this field.                                              |
      | Mr.   | John      |          |        |            |             |                  |          |                 |              |                  |        |            |               |              |              |              |                      | lastName             | Please fill out this field.                                              |
      | Mr.   | John      | Doe      |        |            |             |                  |          |                 |              |                  |        |            |               |              |              |              |                      | gender               | Please select one of these options.                                      |
      | Mr.   | John      | Doe      | M      |            |             |                  |          |                 |              |                  |        |            |               |              |              |              |                      | DOB                  | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/199  |             |                  |          |                 |              |                  |        |            |               |              |              |              |                      | DOB                  | Please match the requested format.                                       |
      | Mr.   | John      | Doe      | M      | 12/13/1990 |             |                  |          |                 |              |                  |        |            |               |              |              |              |                      | SSN                  | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-111  |                  |          |                 |              |                  |        |            |               |              |              |              |                      | SSN                  | Please match the requested format.                                       |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 |                  |          |                 |              |                  |        |            |               |              |              |              |                      | email                | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | alla123          |          |                 |              |                  |        |            |               |              |              |              |                      | email                | Please include an '@' in the email address. 'alla123' is missing an '@'. |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe@.co      |          |                 |              |                  |        |            |               |              |              |              |                      | email                | '.' is used at a wrong position in '.co'.                                |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe@test,co  |          |                 |              |                  |        |            |               |              |              |              |                      | email                | A part following '@' should not contain the symbol ','.                  |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co |          |                 |              |                  |        |            |               |              |              |              |                      | password             | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | 123$John        |              |                  |        |            |               |              |              |              |                      | confirmPassword      | Passwords Do Not Match                                                   |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        |              |                  |        |            |               |              |              |              |                      | address              | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. |                  |        |            |               |              |              |              |                      | locality             | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. | Prospect Heights |        |            |               |              |              |              |                      | region               | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. | Prospect Heights | IL     |            |               |              |              |              |                      | postalCode           | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. | Prospect Heights | IL     | 60070      |               |              |              |              |                      | country              | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. | Prospect Heights | IL     | 60070      | United States |              |              |              |                      | homePhone            | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. | Prospect Heights | IL     | 60070      | United States | 999-233-3312 |              |              |                      | mobilePhone          | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. | Prospect Heights | IL     | 60070      | United States | 999-233-3312 | 999-233-3312 |              |                      | workPhone            | Please fill out this field.                                              |
      | Mr.   | John      | Doe      | M      | 12/13/1990 | 123-31-3234 | johndoe1@test.co | John123$ | John123$        | 123 Main st. | Prospect Heights | IL     | 60070      | United States | 999-233-3312 | 999-233-3312 | 999-233-3312 |                      | agreeToTermsCheckBox | Please check this box if you want to proceed.                            |

#@Negative
#Scenario: Megative case. Account already exists
#  Given the user navigates to signup page
