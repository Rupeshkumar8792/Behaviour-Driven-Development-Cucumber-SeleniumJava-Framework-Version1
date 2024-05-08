Feature: Login Functionality

  Scenario: Verify and Validate the functionality of login with valid details
    Given user navigates to the login page
    When user enter valid username "standard_user"
    And user enter valid password "secret_sauce"
    And user clicks on the loginButton
    Then user should navigate to thye dashboard

  Scenario: Verify and Validate the functionality of login without entering any details
    Given user navigates to the login page
    When user enter dont enter anything in username and password fields
    And user clicks on the loginButton
    Then user should be able to view the error messages
