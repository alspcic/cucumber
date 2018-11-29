Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario


  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    And I should see home page description
    And I should see menu

  Scenario: my first scenario
    Given I am on action page
    When I enter text
    And I click the result button
    Then I see correct result text

