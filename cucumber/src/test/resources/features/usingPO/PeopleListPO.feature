Feature: Introduction to Cucumber homework
  Create new people in list


  Scenario: a new scenario with people
    Given I am on people page
    When I click add new person
      And I fill all fields and languages:
        | language1 | Spanish |
        | language2 | French  |
        | gender    | male    |
      And I save user
    Then I verify that amount of user is now 4
      And I delete last created user



