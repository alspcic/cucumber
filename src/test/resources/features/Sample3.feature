@regression @part3
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debug
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"
  @working
    Examples:
      | name | age | message                      |
      | Ann  | 5   | Hello, Ann, you are a kid    |
      | Bob  | 61  | Hello, Bob, you are an adult |
  @not_working
    Examples:
      | name | age | message                      |
      | Tom  | 15  | Hello, Tom, you are a kid    |
