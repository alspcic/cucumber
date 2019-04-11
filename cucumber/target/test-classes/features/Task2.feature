Feature: Introduction to cucumber part 1
  Check the google page

  Scenario Outline: a new scenario outline
    Given I am on enter a number page
    When I enter "<number>"
    Then I check valid "<number>"
    And I click submit button
    Then I check sqrt value for "<number>"
  @working
    Examples:
      | number |
      | 52     |
      | 78     |
      | 101    |
      | 96     |
