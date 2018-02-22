@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have tables

  Scenario: a new scenario 1 with table
    Given I am on age page
    When I enter values:
      | name | Ann |
      | age  | 5   |
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 1 with table
    Given I am on age page
    When I enter values:
      | name | Bob |
      | age  | 61  |
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"

  @debug
  Scenario Outline: a new scenario outline 2
    Given I am on age page
    When I enter values:
      | name | <name> |
      | age  | <age>  |
    And I click submit age
    Then I see message: "<message>"
    Examples:
      | name | age | message                      |
      | Ann  | 5   | Hello, Ann, you are a kid    |
      | Bob  | 61  | Hello, Bob, you are an adult |