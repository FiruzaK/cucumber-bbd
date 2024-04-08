@regression
Feature: NopCommerce User Registration Feature

  @smoke
  Scenario: NopCommerce Register New User
    Given user is on the homepage
    When user clicks on login link
    Then user should be navigate to login page
    And user should be able to see register button and click it
    Then user should be navigate to register page
    And user clicks on gender as "male"
    And user enter "Kevin" for firstname
    And user enter "Lee" for lastname
    And user enters "15", "May", "1994" for dob
    And user enters "kevin.lee6@gmail.com"
    And user enters "Kevin Technologies LLC" for company
    And user "checks" newsletter checkbox
    And users enters "Kev123!" for password input
    And user enters "Kev123!" for confirm password input
    When user clicks on register button
    Then user should see "Your registration completed" success message
    When user clicks on continue button
    Then user is on the homepage
    And user checks if they can log in with newly created credentials "kevin.lee6@gmail.com" and "Kev123!"




