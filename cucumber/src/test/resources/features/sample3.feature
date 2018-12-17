@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"
  @working
    Examples:
      | name  | age | message                        |
      | Ann   | 5   | Hello, Ann, you are a kid      |
      | Marry | 50  | Hello, Marry, you are an adult |
      | Bob   | 61  | Hello, Bob, you are an adult   |
  @not_working
    Examples:
      | name | age | message                   |
      | Tom  | 15  | Hello, Tom, you are a kid |

  Scenario: Selenium checkbox
    Given I am on action page
    And none of the checkboxes are selected
    When I select option 1 checkbox
    Then I see that option 1 checkbox is selected

  Scenario: Selenium radio button
    Given I am on action page
    And none of the radio buttons are selected
    When I select option 1 radio button
    Then I see that option 1 radio button is selected

  Scenario: Selenium option selector
    Given I am on action page
    And I see "Choose your option" is selected in dropdown
    When I select "Option 1" by text
    Then I see "Option 1" is selected in dropdown

  Scenario: Selenium option selector
    Given I am on action page
    And I see "Choose your option" is selected in dropdown
    When I select "Option 1" by index
    Then I see "Option 1" is selected in dropdown

  Scenario: Selenium option selector
    Given I am on action page
    And I see "Choose your option" is selected in dropdown
    When I select "Option 1" by value
    Then I see "Option 1" is selected in dropdown