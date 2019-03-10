Feature: People with jobs

  Scenario Outline: Add new person
    Given I am on add new person page
    And I click button Reset List
    When I click button Add person
    And I input person name: "<name>"
    And I input person surname: "<surname>"
    And I input person job: "<job>"
    And I input person date of birth: "<date of birth>"
    And I select language:
      | language1   | language2   |
      | <language1> | <language2> |
    And I select gender: "<gender>"
    And I select status: "<status>"
    Then I click button Add
    Then I am able to see person added to a list:
      | name   | surname   | job   | date of birth   | language1   | language2   | gender   | status   |
      | <name> | <surname> | <job> | <date of birth> | <language1> | <language2> | <gender> | <status> |

   Examples:
    | name  | surname | job    | date of birth | language1 | language2 | gender | status     |
    | Gerda | Snow    | tester | 01/01/1990    | English   | Spanish   | female | employee   |
    | Kaj   | Snow    | devops | 01/01/1990    | English   | French    | male   | contractor |
