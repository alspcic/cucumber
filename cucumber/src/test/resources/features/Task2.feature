Feature:
  As a test engineer
  I want to be able to add new persons to people with jobs list

  Scenario Outline: TASK 2. 001. Add new persons to people with jobs list
    When I am on the People with jobs page
    And I click Reset list button
    And I click Add person button
    And I enter "<Name>" value in the "name" field
    And I enter "<Surname>" value in the "surname" field
    And I enter "<DateOfBirth>" value in the "date of birth" field
    And I enter "<Job>" value in the "job" field
    And I enter "<Gender>" value in the "gender" field
    And I enter "<Status>" value in the "status" field
    And I enter languages:
      | <Language 1> |
      | <Language 2> |
    And I click Add button
    Then I see new person is added with corresponding data
      | Name        | <Name>        |
      | Surname     | <Surname>     |
      | Job         | <Job>         |
      | DateOfBirth | <DateOfBirth> |
      | Gender      | <Gender>      |
      | Status      | <Status>      |
      | Languages   | <Languages>   |


    Examples:
      | Name   | Surname | Job    | DateOfBirth | Gender | Status     | Language 1 | Language 2 | Languages         |
      | Chuck  | Norris  | Actor  | 02/21/1942  | Male   | Contractor | English    | French     | English, French,  |
      | Lara   | Croft   | Raider | 02/02/1996  | Female | Intern     | English    | Spanish    | English, spanish, |
      | Mickey | Mouse   | Mice   | 02/21/1929  | Male   | Employee   | French     | English    | English, French,  |