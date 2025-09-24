
Feature: Testing Vegetables site 
  
  @automation1
  Scenario Outline: User is redirected to the vegetable 
    Given User is on Vegetable site LandingPage
    When User checks for the <name> in search and add it to cart
    And User goes to offers page and seacrhes for <name>
    Then  <name> is displayed on the page
    

    Examples: 
    	| name |
      | straw  |
      | cau |
      | tom |
      |  1 |

