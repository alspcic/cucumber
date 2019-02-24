@testAddPerson
Feature: Introduction to Cucumber
  As a user I want to create 2 new people and verify that it was added to a list

  Scenario Outline: Add People
    Given I am on List of People page
    When I click Reset List
    And I click Add person button
    And I enter name in name field: "<name>"
    When I enter surname in surname field: "<surname>"
    And I enter job in field: "<job>"
    When I enter date of birth: "<dob>"
    When I click on languages checkboxes:
      | french  |
      | spanish |
    And I select "<gender>"
    And I select employee status "<status>"
    And I click Add button
    Then A new person "<name>" "<surname>" with job "<job>" and status "<status>" of gender "<gender>" which is born "<dob>" is added

    Examples:
      | name | surname | job   | dob        | gender | status |
      | Anna | White   | Nurse | 10/10/1958 | female | intern |
      | John | Don     | Driver | 12/05/1990 | male| intern |