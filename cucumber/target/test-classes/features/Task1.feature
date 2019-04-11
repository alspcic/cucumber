Feature: Introduction to cucumber part 1
  Check the number in page

  Scenario Outline: a new scenario outline
    Given I am on number page
    When I enter number: "<number>"
    And I click submit number
    Then I see error message: "<errorMessage>"


    Examples:
      | number  | errorMessage              |
      | 43      |  Number is too small      |
      | 110     |  Number is too big        |
