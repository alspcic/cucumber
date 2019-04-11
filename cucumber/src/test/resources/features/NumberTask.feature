Feature: Introduction to cucumber part 1
  Check error message on the page

  Scenario Outline: Check errors scenario
    When I am on the numbers page
    Then I see the number header
    And I see text field for numbers
    When I enter number <number>
    And I click button Submit
    Then I see error message <message>

    Examples:
      | number | message             |
      | 31     | Number is too small |
      | 103    | Number is too big   |