Feature: People with jobs

  Scenario: Simple scenario
  When I am on the People with jobs list page
  Then I click button 0 Add person on PeopleList
  When I enter person data on PersonAddPage:
    | name        | John          |
    | surname     | Doe           |
    | job         | Test engineer |
    | dateofbirth | 04/23/2019    |
    | gender      | male          |
    | status      | Contractor    |
  And I check languages on PersonAddPage:
    | English |
    | French  |
  Then I click Add button on PersonAddPage
  And I see 4 persons in the list on PeopleList
  When I delete person: "John Doe" on PeopleList
  Then I see 3 persons in the list on PeopleList



