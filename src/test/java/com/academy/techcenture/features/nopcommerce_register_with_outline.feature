Feature: NopCommerce User Registration Feature
  @register
  Scenario Outline: NopCommerce Register New User
    Given user is on the homepage
    When user clicks on login link
    Then user should be navigate to login page
    And user should be able to see register button and click it
    Then user should be navigate to register page
    And user clicks on gender as "<gender>"
    And user enter "<firstname>" for firstname
    And user enter "<lastname>" for lastname
    And user enters "<day>", "<month>", "<year>" for dob
    And user enters "<email>"
    And user enters "<company_name>" for company
    And user "<newsletter>" newsletter checkbox
    And users enters "<password>" for password input
    And user enters "<confirm_password>" for confirm password input
    When user clicks on register button
    Then user should see "<success_message>" success message
    When user clicks on continue button
    Then user is on the homepage
   # And user checks if they can log in with newly created credentials "<email>" and "<password>"
    Examples:
    |gender|firstname|lastname| day | month | year |        email        |  company_name   | newsletter | password | confirm_password |       success_message      |
    | male | kevin   |  lee   | 10  |   May | 1994 | kevin.lee9@gmail.com| Techcenture LLC |   checks   |  Kev123! |     Kev123!      | Your registration completed|
    |female| jassee  |  lee   | 11  | April | 1995 |jassee.lee2@gmail.com| Techcenture LLC | unchecks   |  Kev123! |     Kev123!      | Your registration completed|
    | male | bob     |  lee   | 12  |  June | 1991 | bob.lee2@gmail.com  | Techcenture LLC |   checks   |  Kev123! |     Kev123!      | Your registration completed|
    |female| kaley   |  lee   | 13  |  July | 2000 | kaley.lee2@gmail.com| Techcenture LLC | unchecks   |  Kev123! |     Kev123!      | Your registration completed|

