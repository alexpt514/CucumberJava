Feature: Test Login on Google

	@testtag
  Scenario: Check Login is valid
    Given user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user is redirected to the email page

  	Examples: 
      | username  | password |
      | name1 |     abc |

      

      @testtag1
  Scenario: Check Login is valid
    Given user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user is redirected to the email page