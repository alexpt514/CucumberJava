
@regression @edge
Feature: Edge and Negative Scenarios

  Scenario: Search input is blank
    Given I am on the GreenKart home page
    When I search with blank input
    Then I should see all products
    #Or an instruction to enter something for search

  Scenario: Adding a product not listed
    Given I am on the GreenKart home page
    When I try to add a product named "DragonFruit"
    Then I should not be able to
    And an appropriate message or no action

  Scenario: Quantity becomes zero
    Given I have added "Carrot" with quantity 1
    When I decrease quantity by 1
    Then the item is removed from cart
    And cart updates accordingly