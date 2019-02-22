Feature: EnterName

  Scenario Outline: Task 3
    Given I go to "kristinek.github.io/site/tasks/list_of_people"
    And I click the reset button
    And I click the add person button
    And I enter name: "<name>"
    And I enter surname: "<surname>"
    And I click the radiobutton
    And I enter date of birth: "<date>"

    When I chose language:
      | english |
      | spanish |
    And I click the Add button
    And I should see page List of people
#   And Pause
    And I verify new added persons in list


    Examples:
      | name   | surname | date       |
      | Bob    | Dilan   | 07/05/1990 |
      | Jackie | Chan    | 08/05/1980 |

