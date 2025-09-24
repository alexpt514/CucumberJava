
@regression @cart
Feature: Cart Summary and Pricing

  Scenario: Verify total price of items in cart
    Given I have added "Brocolli" (₹ 120) and "Cauliflower" (₹ 80) to the cart
    When I view the cart summary
    Then the sum of individual items prices should equal the total displayed

  Scenario: Verify delivery fee or tax if applicable
    Given I have items in the cart
    When I go to checkout
    Then any delivery fee or tax should be correctly computed
    And total payable should reflect items + fees

  Scenario: Empty cart behaviour
    Given my cart is empty
    When I view the cart
    Then I should be shown message “Your cart is empty” or similar
    And checkout or proceed button should be disabled or hidden