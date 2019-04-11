Feature: second task

  Scenario Outline: a new scenario outline
    Given I am on enter number page
    When I enter age : "<age>"
    And click submit button
    Then I see a message: "<message>"

    Examples:
    |age|message|
    |43 |Number is too small  |
    |101|Number is too big    |
