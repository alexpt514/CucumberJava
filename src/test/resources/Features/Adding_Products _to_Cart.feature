
@adding_products
Feature: Adding Products to Cart
@adding1
  Scenario Outline: Add a single product to cart
    Given User is on Vegetable site LandingPage
    When I search for <name>
    And I add the product to the cart
    Then the cart should show 1 item added
    And the cart shows the correct name <name>
    
      Examples: 
  		| name |	
      | Cucumber  | 
       
        
@smokw
  Scenario Outline: Add multiple different products
    Given User is on Vegetable site LandingPage
    When I search for "Tomato"
    And I add the product to the cart
    And I search for "Potato"
    And I add the product to the cart
    Then the cart should show 2 item added
    And added item should appear with correct quantity <quant>
    
 @adding2 
  Scenario Outline: Add products to cart
	  Given User is on Vegetable site LandingPage
	  When I search for <product1>
	  And I add the product to the cart
	  And I search for <product2>
	  And I add the product to the cart
	  Then the cart should show <count> item added
	  And added item should appear with correct quantity <quant>

Examples:
  | product1 | product2 | count | quant |
  | Tomato   | Potato   | 2     | 1     |
  | Carrot   | Cucumber | 2     | 1     |
    

  Scenario: Add same product twice
    Given User is on Vegetable site LandingPage
    When I search for "Brinjal"
    And I add "Brinjal" to the cart
    And I add "Brinjal" again
    Then the cart should show quantity of "Brinjal" is 2