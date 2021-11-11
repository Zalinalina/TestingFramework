@all
Feature: the basic shopping cart and checkout workflow


  Scenario: Login as standard user
    Given user is on the login page
    When user enters the username "standard_user" and password "secret_sauce"
    And user click on the login button
    Then user should see the "Swag Labs" page


  Scenario: Add item into cart and verify item is correct
    Given user is on the home page
    When user click on add to cart button near chosen item
    And user click on the view card button
    Then user should be able to see correct item in the cart

  Scenario: Place order
    Given user on the cart page
    When user click on checkout button
    And user fill in "Michael", "Forbs"  and "22180" fields
    And user click on continue button
    And user should be able to review order and click finish button
    Then user should be able to complete the order







