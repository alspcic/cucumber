Feature: Introduction to cucumber part 1
  Check the google page

  Scenario Outline: a new scenario outline
    Given I am on enter a number page
    When I enter "<number>"
    Then I check invalid "<number>"
    And I click submit button
    Then I see warning message: "<message>"
  @working
    Examples:
      | number | message             |
      | 43     | Number is too small |
      | 101    | Number is too big   |
