Feature: Final task.
//  1. go to https://kristinek.github.io/site/tasks/list_of_people
//  2. Reset person list
//  3. Add two new people using Scenario Outline
//  4. Fill required data *
//  5. Click on add button
//  6. Verify that new name <name> is added to a list


  Scenario Outline: Final Task Scenario
    Given Go to task page
    And I reset person list
    And  I click Add Person button
    And  I input new persons name: "<name>"
    And  I input new persons surname: "<surname>"
    And  I input new persons job: "<job>"
    And  I input new persons date of birth "<birthday>"
    And  I select new persons language:
        |  language1  |  language2  |
        | <language1> | <language2> |
    And  I select persons gender: "<gender>"
    And  I select persons status: "<status>"
    And  I click Add button
    And  I verify that new people are in the list:
      |  name   | surname |  job  | birthday  |language1  | language2 | gender | status   |
      |  <name> |<surname>| <job> | <birthday>|<language1>|<language2>|<gender>| <status> |



    Examples:
    |  name   | surname |    job    |  birthday  | language1 | language2 | gender |   status   |
    | William |  Smith  | FBI Agent | 21.06.1953 |  French   |  English  |  male  | contractor |
    | Barbara |   Wild  |  Actress  | 07.09.1977 |  Spanish  |  French   | female |   emloyee  |

