Feature: This feature checks people with jobs

  Scenario Outline: People With Jobs
    Given I go to "kristinek.github.io/site/tasks/list_of_people"
    When I "<Reset before run>"
    And I click Add Person button
    Then I see Add new person form
    When I fill Name from "<Name>"
    And I fill Surname from "<Surname>"
    And I fill Job from "<Job>"
    And I fill Date of birth from "<Date of birth>"
    And I choose language :
      | English |
      | Spanish |
    And I pick Gender from "<Gender>"
    And I click Add button
    Then I see that person was added


    Examples:
      | Name | Surname  | Job    | Date of birth | Gender | Reset before run |
      | John | Doe      | Killer | 02/08/1980    | Male   | true             |
      | Anna | Shponkel | Dancer | 05/10/1998    | Female | false            |