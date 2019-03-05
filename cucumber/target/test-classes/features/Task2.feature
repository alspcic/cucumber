@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: right input
    Given I am on enter_a_number page
    When I enter number: <number>
    And I click submit number button
    Then I see result popup
  @working
    Examples:
  | number | message                        |
  | 75     | Hello, Marry, you are an adult |

  @debugs
  Scenario Outline: wrong input
    Given I am on enter_a_number page
    When I enter number: <number>
    And I click submit number button
    Then I see result message: "<message>"
    Examples:
      | number | message                        |
      | 25     | Hello, Ann, you are a kid      |
      | 110    | Hello, Bob, you are an adult   |



