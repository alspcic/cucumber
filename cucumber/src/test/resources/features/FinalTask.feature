Feature: Final Cucumber brownbag task
  As a user I want to create 2 new people and verify that it was added to a list


  Scenario Outline: Add 2 people to the list
    Given User is on the person list page
    Then I click on add person button
    And I enter the name: "<name>" and surname: "<surname>"
    And I enter the job: "<job>" and date of birth: "<dob>"
    Then I select the gender "<gender>"
    And I select specific languages
      | french |
      | spanish|
    When I click on add button
    Then I see the newly added user "<name>" in the list
    Examples:
      | name    | surname | job     | dob         | gender  |
      | Richard | dunty   | manager | 03/12/1990  | male    |
      | Rachel  | song    | clerk  | 04/1/1986   | female   |


