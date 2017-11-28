Feature:Create Amazon UK account

  Background: Use is on Homepage.
    Given User is on Home Page

  @MyTest1
  Scenario Outline:Verify user can create Amazon UK account
    When User click on Sign up button
    And Fill up require details as "<Name>" "<Password>" "<ReEnterPS>"
    And click on sign up button
    Then User should get "<Result>" message after registration

    Examples:
      | Name | Password  | ReEnterPS | Result                   |
      | Sam  |           |           | Enter your password      |
      | Sam  | Danial123 |           | Type your password again |
      |      | Danial123 | Danial123 | Enter your name          |
      | Sam  | Danial123 | Danial124 | Passwords do not match   |
      | Sam  | Danial123 | Danial123 | Hello, Sam               |

  @MyTest
  Scenario: Verify use can log in successfully
    When Use Log In successfully
    Then User should get "Hi, Sam" message on the screen


  Scenario Outline: Verify user can search for Items add them to the shopping list
    When User search for items as "<ItemName>"
    And add them to the shopping list
    Then Shopping trolley should display correct items as "<ItemName>"

    Examples:
      | ItemName               |
      | Beats by Dr. Dre Solo3 |

  Scenario:
    Given
    When
    Then
      | Sony Bravia   |
      | USB LED Light |