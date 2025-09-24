
@regression @searching
Feature: Search for items
  As a user
  I want to search for vegetables/fruits
  So that I can find the items I want to purchase
@searching1
  Scenario Outline: Search with exact match
    Given User is on Vegetable site LandingPage
    When I search for <name>
    Then Search results should display items matching <name>
    
    Examples:
    | name |
    | Tomato |
    | Cauliflower |
    | Cucumber |
    | Raspberry |
@searching2
  Scenario Outline: Search with partial keywords
    Given User is on Vegetable site LandingPage
    When I search for <name>
    Then Search results should display items that contain <long_name> or similar
    
    Examples:
    | name |long_name |
    | tom | Tomato |
    | cau | Cauliflower |
    | cuc | Cucumber |
    | rasp | Raspberry |
    
@searching3
  Scenario: Search with no matching items
    Given User is on Vegetable site LandingPage
    When I search for "XYZ"
    Then the result area should display no products message or be empty