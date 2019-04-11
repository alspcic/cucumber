Feature: Task 2

  Scenario: Navigation to 'Enter a number' page check
    Given I navigate to the 'https://kristinek.github.io/site/#' page
    And I see 'This is a home page' on the Krisinec page
    And I see 'Tasks' on the Krisinec page
    When I click on 'Tasks' on the Krisinec page
    And I select 'Enter a number' option from the 'Task toolbar' menu on the Krisinec page
    Then I see 'Enter a number' on the Krisinec page
    And I see 'Submit' on the Krisinec page

  Scenario Outline: Square root check on 'Enter a number' page (Negative)
    Given I navigate to the 'https://kristinek.github.io/site/#' page
    And I click on 'Tasks' on the Krisinec page
    And I select 'Enter a number' option from the 'Task toolbar' menu on the Krisinec page
    When I enter '<textEntered>' on the Krisinec page
    And I click on 'Submit' on the Krisinec page
    Then I see '<errorExpected>' error on the Krisinec page

    Examples:
      | textEntered | errorExpected                |
      | 49          | Number is too small          |
      | 101         | Number is too big            |
      | a           | Please enter a number        |
      | $           | Please enter a number        |
      | 49.99       | Number is too small          |
      | -1          | Number is too small          |
      |             | You haven't entered anything |

  Scenario Outline: Square root check on 'Enter a number' page (Positive)
    Given I navigate to the 'https://kristinek.github.io/site/#' page
    And I click on 'Tasks' on the Krisinec page
    And I select 'Enter a number' option from the 'Task toolbar' menu on the Krisinec page
    When I enter '<textEntered>' on the Krisinec page
    And I click on 'Submit' on the Krisinec page
    Then I see correctly calculated square root for entered '<textEntered>' on the Krisinec page

    Examples:
      | textEntered |
      | 50          |
      | 64          |
      | 100         |