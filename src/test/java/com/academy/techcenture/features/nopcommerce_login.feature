Feature: NopCommerce Login Feature
  Scenario: NopCommerce User Login Positive Scenario
    Given user is on the homepage
    When user clicks on login link
    Then user should be navigate to login page
    When user uses login credentials "kevin.lee@gmail.com" and "Kevin123!" and clicks on login button
    Then user should be able to log in

  Scenario: NopCommerce User Login Negative Scenario
    Given user is on the homepage
    When user clicks on login link
    Then user should be navigate to login page
    When user uses login credentials "kevin.lee@gmail.com" and "Kevin888!" and clicks on login button
    Then user should see error "Login was unsuccesful. Please correct the errors and try again. No customer account found"