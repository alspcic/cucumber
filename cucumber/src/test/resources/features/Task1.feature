Feature: Task 1
  As a test engineer
  I want to be able to write cucumber tests.


  Scenario: Google
    Given I am on the web page: "https://www.google.com/"
    When I verify Google Search button text
    And I verify Google Lucky button text
    And I should see google image

  Scenario Outline: Sqrt output
    Given I am on the web page: "https://kristinek.github.io/site/tasks/enter_a_number"
    When I enter number: <number>
    And I click submit
    And I verify error: <message>
    Then  I should see a popup with text: <popup>

    Examples:
      | number  |   message                      |
      | 3       |   Number is too small          |
      | 0.3     |   Number is too small          |
      |         |   You haven't entered anything |
      | -10     |                                |
      | 50      |                                |
      | 55      |                                |
      | 80.7    |                                |
      | 100     |                                |
      | 999     |   Number is too big            |
      | 100.0   |                                |