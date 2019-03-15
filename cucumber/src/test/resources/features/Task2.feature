Feature: Final Task
  I want to add several persons to list

  Background:
    Given I go to Task Create People page
    And I reset the person list
    And I click add person button

  Scenario Outline: Final Task
    When I enter new person info:
      | name       | <name>            |
      | surname    | <surname>         |
      | job        | <job>             |
      | dob        | <date of birth>   |
      | <language> | <language>        |
      | <gender>   | <gender>          |
      | status     | <status>          |
    And I click add button
    Then I see a person added to the list: "<name>"
    Examples:
      | name    | surname   | job     | date of birth | language | gender | status      |
      | Bob     | Dylan     | Singer  | 24/05/1941    | english  | male   | Specialist  |
      | Solvita | Aboltina  | Jobless | 19/02/1963    | french   | female | Useless     |