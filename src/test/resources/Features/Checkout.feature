
@regression @checkout
Feature: Checkout Process

  Scenario: Successful checkout with valid details
    Given I have items in the cart
    When I proceed to checkout
    And I enter valid delivery address details
    And I choose a payment option
    Then I should see an order confirmation message
    And my cart becomes empty afterwards

  Scenario: Checkout prevented if no items in cart
    Given my cart is empty
    When I try to proceed to checkout
    Then I should not be allowed to proceed
    And I should see a message to add items first

  Scenario: Checkout with invalid address
    Given I have items in the cart
    When I proceed to checkout
    And I enter invalid/blank address details
    Then I get error messages for required fields
    And checkout is not successful