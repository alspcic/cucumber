@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have tables

  Background:
    Given I am on age page

  Scenario: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:
      | Option 1 |
      | Option 3 |
    And I click the result checkbox button
    Then message for checkboxes "You selected value(s): Option 1, Option 3" is seen

  Scenario: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:
      | Option 2 |
    And I click the result checkbox button
    Then message for checkboxes "You selected value(s): Option 2" is seen


  Scenario: a new scenario with 2-row table
    When I enter values:
      | name | Ann |
      | age  | 5   |
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: another new scenario with 2-row table
    When I enter values:
      | name | Bob |
      | age  | 61  |
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"
@test
  Scenario: my scenario with tables
    When I am on number page
    Then I see error if I enter numbers:
      | 3   | Number is too small |
      | 103 | Number is too big   |

  @debug
  Scenario Outline: a new scenario outline 2
    When I enter values:
      | name | <name> |
      | age  | <age>  |
    And I click submit age
    Then I see message: "<message>"
    Examples:
      | name | age | message                      |
      | Ann  | 5   | Hello, Ann, you are a kid    |
      | Bob  | 61  | Hello, Bob, you are an adult |

