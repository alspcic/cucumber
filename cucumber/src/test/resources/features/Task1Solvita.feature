Feature: Enter an information
  As a test engineer
  I want to be able to write and execute a scenario with parameters


  Scenario: Google page test
    Given I am on Google page
    And I verify Google Search button text
    And I verify Google Lucky button text
    And I see Google image
    When I enter text: Zoo
    And I click enter
    Then I should see: "Rīgas Nacionālais zooloģiskais dārzs"


  Scenario Outline: Task 2
    Given I go to Task 1 page
    When I enter number: "<number>"
    And I click the button
    Then I verify message: "<message>"
    Examples:
    | number | message                      |
    | 5      | Number is too small          |
    | 105    | Number is too big            |
    | a      | Please enter a number        |
    |        | You haven't entered anything |
    | 75     | Square root of 75 is 8.66    |

