Feature: User like to login in gmail account

  @Test

  Scenario: User can login with valid login details
    Given customer is on google homepage
    When User click on Gmail button from Toolbar
    And Type User name and password
    And Click Next button
    Then User can see gmail homepage

    @Test2
  Scenario: User can not login with invalid login password details
    Given customer is on google homepage
    When User click on Gmail button from Toolbar
    And Type User name and password
    And Click Next button
    Then User can see gmail homepage

  @Test2
  Scenario: User can not login with invalid login user details
    Given customer is on google homepage
    When User click on Gmail button from Toolbar
    And Type User name and password
    And Click Next button
    Then User can see gmail homepage