Feature: Final task

  Scenario: Navigation check to 'People with jobs' page
    Given I navigate to the 'https://kristinek.github.io/site/#' page
    And I see 'This is a home page' on the Krisinec page
    When I click on 'Tasks' on the Krisinec page
    And I select 'People list' option from the 'Task toolbar' menu on the Krisinec page
    Then I see 'People with jobs' on the People list page

  Scenario: Elements check on 'People with jobs' page
    When I navigate to the 'https://kristinek.github.io/site/tasks/list_of_people' page
    Then I see 'People with jobs' on the People list page
    And I see following buttons on the People list page
      | Add person |
      | Reset List |
    And I see following elements on the People list page
      | List of people     |
      | Edit icon button   |
      | Delete icon button |
    And I see copyright text "(c) Who would even want to steal this?" on the People list page

  Scenario: 'Add person' button check
    Given I navigate to the 'https://kristinek.github.io/site/tasks/list_of_people' page
    When I click on 'Add person' on the People list page
    Then I see 'People with jobs' on the Adding new person page
    And I see following buttons on the Adding new person page
      | Clear all fields |
      | Add              |
      | Cancel           |
    And I see following labels on the Adding new person page
      | Name              |
      | Surname           |
      | Job               |
      | Date of birth     |
      | Knows language(s) |
      | English           |
      | French            |
      | Spanish           |
      | Gender            |
      | Male              |
      | Female            |
      | Employee status   |
    And I see following elements on the Adding new person page
      | Name text field          |
      | Surname text field       |
      | Job text field           |
      | Date of birth text field |
      | English checkbox         |
      | French checkbox          |
      | Spanish checkbox         |
      | Male radio button        |
      | Female radio button      |
      | Employee dropdown        |

  Scenario: Creating new person
    Given I navigate to the 'https://kristinek.github.io/site/tasks/list_of_people' page
    And I see 3 person in the list on the People list page
    And I click on 'Add person' on the People list page
    When I fill following fields on the Adding new person page
      | field                    | value      |
      | Name text field          | Lady       |
      | Surname text field       | Gaga       |
      | Date of birth text field | 03/28/1986 |
      | Job text field           | Singer     |
    And I select following language on the Adding new person page
      | English checkbox |
      | French checkbox  |
    And I select 'female' gender on the Adding new person page
    And I select option 'contractor' from 'Employee status' dropdown on the Adding new person page
    And I click on 'Add' on the Adding new person page
    Then I see 4 person in the list on the People list page
    And I click on 4 delete icon button from the list on the People list page
    And I see 3 person in the list on the People list page