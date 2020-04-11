@myTest
Feature: Introduction to cucumber part 1

  Scenario: Simple scenario
    Given I am on the Google page
    When I verify Google Search button text
    And I verify google lucky button text
    And I should see google image
    Then I enter: "demo" text in search field
    And press Google search button

  Scenario: Enter a number 1
    Given I am on task page
    When I enter number: 335
    Then I should see an error: "Number is too big"

  @mysecondTest
  Scenario Outline: Enter a number
    Given I am on task page
    When I enter number: <number>
    Then I should see an error: <error message>
    Examples:
      | number | error message         |
      | 35     | "Number is too small" |
      | 335    | "Number is too big"   |
#  @bug
#    Examples:
#      | number | error message         |
#      | 666    | "Number is too big"   |