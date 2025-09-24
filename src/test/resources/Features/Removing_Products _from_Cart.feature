@regression @removing
Feature: Removing or Updating Cart Items

  Scenario: Remove a product from the cart
    Given I have added "Tomato" and "Potato" to the cart
    And the cart shows 2 items
    When I remove "Tomato"
    Then the cart should show only "Potato"
    And the total items count should be 1

  Scenario: Decrease quantity of a product in cart
    Given I have added "Onion" with quantity 2
    When I reduce quantity of "Onion" by 1
    Then the cart shows quantity of "Onion" as 1
    And price for "Onion" reflects quantity 1

  Scenario: Increase quantity of a product in cart
    Given I have added "Carrot" to the cart
    When I increase quantity of "Carrot" by 2
    Then the cart should show quantity 3
    And price updates accordingly