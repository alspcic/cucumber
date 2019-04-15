Feature: Introduction to cucumber part 2
  Check possibility to add and delete people from the page

  Scenario: Simple scenario working with people page
    When I navigate to People with jobs page
    Then I see People with jobs page is loaded
    And I see <Add person> button
    And I see <Reset List> button
    And I see <3> persons on the page list
    When I click button <Add person>
    Then I see Adding new person page
    And I see <Clear all fields> button
    And I see titles:
      | Name              |
      | Surname           |
      | Job               |
      | Date of birth     |
      | Knows language(s) |
      | Gender            |
      | Employee status   |
    And I see <Add> button
    And I see <Cancel> button
    When I enter values:
      | name    | Maksims         |
      | surname | Laitans         |
      | job     | Test Automation |
      | dob     | 04/16/2019      |
    And I check values:
      | english |
      | spanish |
      | male    |
    And I choose <Intern> value from <Employee status> dropdown
    And I click button <Add>
    Then I see People with jobs page is loaded
    And I see <4> persons on the page list
    And I see values for person number <4>
      | name     | Maksims           |
      | surname  | Laitans           |
      | job      | Test Automation   |
      | dob      | 04/16/2019        |
      | language | English, spanish, |
      | gender   | male              |
      | status   | intern            |
    When I click button delete for person <4>
    Then I see <3> persons on the page list