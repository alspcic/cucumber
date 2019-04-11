Feature: Test for roadmap

  Scenario: testing google
    Given I am on Google page
    When I verify Google search button text
    And I verify Google lucky button text
    And I should see google image

#  To create step use alt+enter
#  To go inside of the step : ctrl + leftclick

  Scenario Outline: Task 2
    Given I go to "kristinek.github.io/site/tasks/enter_a_number"
    And I enter number: <number>
    And I click the button
    And I verify error "<message>"

    Examples:
      | number | message             |
      | 101    | Number is too big   |
      | 47     | Number is too small |
