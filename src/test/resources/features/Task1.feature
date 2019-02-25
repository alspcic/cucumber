Feature: ENTER A NUMBER

  Scenario Outline: TASK 001. Enter a number and verify message
    When I am on the Enter a number task page
    And I enter number: "<Number>"
    And I click Submit button
    Then I verify message is: "<Message>"

    Examples:
      | Number | Message             |
      | 25     | Number is too small |
      | 150    | Number is too big   |

  Scenario Outline: TASK 002. Enter a number and check alert text
    When I am on the Enter a number task page
    And I enter number: "<Number>"
    And I click Submit button
    Then I verify alert message is: "<AlertText>"
    And I verify root in alert message is correctly calculated for entered number: "<Number>"

    Examples:
      | Number | AlertText                 |
      | 50     | Square root of 50 is 7.07 |