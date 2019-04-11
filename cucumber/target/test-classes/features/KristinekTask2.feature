Feature: this feature will check numbers.
  
  Scenario: Check number
    Given I go to "kristinek.github.io/site/tasks/enter_a_number"
    When I enter number: 100
    And I check this number according to the rules
    And I click the button
    Then I see popup message
