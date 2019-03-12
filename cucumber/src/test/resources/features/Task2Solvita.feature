Feature: Final Task
  I want to add 2 persons to list

  Background:
    Given I go to Task Create People page
    And I reset person list
    And I click add person button

  Scenario Outline: Final Task Add People
    When I enter new person info:
      | name       | <name>            |
      | surname    | <surname>         |
      | job        | <job>             |
      | dob        | <date of birth>   |
      | <language> | <language>        |
      | <gender>   | <gender>          |
      | status     | <employee status> |
    And I click add button
    Then I see person added to list: "<name>"
    Examples:
      | name | surname | job  | date of birth | language | gender | employee status |
      | Lita | Yes     | Boss | 01/01/1990    | french   | female | Contractor      |
      | John | Nay     | Chef | 13/02/2000    | spanish  | male   | Intern          |