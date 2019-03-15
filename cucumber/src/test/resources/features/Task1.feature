Feature: Enter information in google search page
  As a test engineer
  I want to be able to write and execute a scenario with parameters


  Scenario: Google page test
    Given I am on Google page
    And I verify Google Search button text
    And I verify Google Lucky button text
    And I see Google image
    When I enter text: "Accenture"
    And I click enter
    Then I should see: "Accenture | New insights. Tangible outcomes. New Applied Now"


  Scenario Outline: Task 2
    Given I go to Task Webpage
    When I enter number: "<number>"
    And I click the button
    Then I verify message: "<message>"
    Examples:
    | number | message                      |
    |        | You haven't entered anything |
    | 4      | Number is too small          |
    | 999    | Number is too big            |
    | zz     | Please enter a number        |
    | 75     | Square root of 75 is 8.66    |

