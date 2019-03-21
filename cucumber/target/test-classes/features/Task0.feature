Feature: Introduction to cucumber part 1
  Check the google page
  Get the square root from number

  Scenario: Simple scenario
    When I am on Google homepage
    Then I verify lucky button text
    And I verify google search button text
    And I see Google image
    And I enter some text in searchbox


  Scenario Outline: Square Root
    Given I go to square root calculation page
    And I enter number: "<number>"
    And I click the button
    And I verify error: "<message>"

    Examples:
    | number  | message                   |
    | 5       | Number is too small       |
    | 777     | Number is too big         |
    | a       | Please enter a number     |
    | 75      | Square root of 75 is 8.66 |