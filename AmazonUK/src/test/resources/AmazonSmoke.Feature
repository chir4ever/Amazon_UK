Feature: As a customer i like to Verify Home Page feature

  Background:User is on Home Page
    Given User is on Home Page


  @MyTest

  Scenario Outline: Verify key button are visible from Home Page
    Then Following buttons as "<ButtonID>""<ButtonName>" should be present on homepage
    And User should able to click each button "<ButtonID>""<ButtonName>""<ClickMessage>" individually


    Examples:
      | ButtonID                   | ButtonName                 | ClickMessage                       |
      | Help                       | Help page                  | Browse Help Topics                 |
      | Amazon Assistant           | Amazon Assistant           | Shop smarter online                |
      | Become an Amazon Vendor    | Become an Amazon Vendor    | Vendor Express                     |
      | Hello. Sign in             | Sing In                    | E-mail (phone for mobile accounts) |
      | Try Prime                  | Try Amazon Prime           | Start your 30-day Prime free trial |
      | Today's Deals              | Today's deal               | Deals of the Day                   |
      | Sell                       | Sell item                  | Start Selling                      |
      | Top Up Your Account        | Top Up Your Account        | Choose the Way to Top Up           |
      | Sell on Amazon             | Sell on Amazon             | Start Selling                      |
      | Sell on Amazon Business    | Sell on Amazon Business    | Sell on Amazon Business            |
      | Advertise Your Products    | Advertise Your Products    | Get started                        |
      | Amazon Platinum Mastercard | Amazon Platinum Mastercard | Check eligibility now              |
      | Top Up Your Account        | Top Up Your Account        | About Top Up                       |
      | Returns                    | Returns                    | Returns Support Centre             |
      | Basket                     | Basket                     | Your Shopping Basket               |
      | Department                 | Shop by Department         | Kindle                             |









