Feature: Introduction to cucumber part 1

  Scenario: Simple scenario
    Given I am on the google page
    When I verify Google Search button text
    And I verify google lucky button text
    And I should see google image

  Scenario Outline: entering enter number page
    Given I am on enter number page
    And I enter name: "<name>"
    And I enter number: <number>
    And I click submit button
    Then I see message: "<message>"

    Examples:
      | number | message       |
      | 43     | error message |
      | 111    | error message |

  To create a step use: Alt+Enter
  To go inside of the step: Ctrl + left click
  ctrl + space



