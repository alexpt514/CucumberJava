  Feature: Testing Vegetables site 
  
  @automation2
  Scenario Outline: User is redirected to the vegetable 
    Given User is on Vegetable site LandingPage
    When User checks for the <name> in search 
    And adds <quant> to cart
    And User goes to Checkout
    Then  <name> and <quant> are displayed on the page
    #Then  <name> is displayed on the page
    #And 	<quant> is displayed on the page
    
        Examples: 
  		| name |	quant	|
      | tom  | 3 |
      | straw | 2 |
      
 			
 			#dado que sou cliente e assido o site 
 			#quando realizo uma compra /cenario do exemplo para usar no switch/
 			#entao a compra foi realizada com sucesso 