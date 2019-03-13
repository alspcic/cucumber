Feature: Create multiple people
  As a user
  I want to add 2 new people
  So that I can validate that they are added to the list

  Scenario Outline:  Create New People
    Given I am on the overview page
    When I press on Reset List button
    And I press on Add Person button
    And I enter persons name: "<name>"
    And I enter persons surname: "<surname>"
    And I enter persons job: "<job>"
    And I enter persons date of birth: "<dateOfBirth>"
    And I select languages:
      |languages    |
      |english      |
      |french       |
    And I select gender: "<gender>"
    And I choose status: "<employeeStatus>"
    And I click on Add button
#    Then I validate the person added "<name>" "<surname>" Job: "<job>" Date of birth: "<dateOfBirth>" Knows languages: "languages" Gender: "<gender>" Employee status: "<employeeStatus>"
#    Then I validate the person added "<name>" "<surname>" Job: "<job>" Date of birth: "<dateOfBirth>" Gender: "<gender>" Employee status: "<employeeStatus>"
    Then I validate the person added "<name>" "<surname>" Job: "<job>" Date of birth: "<dateOfBirth>" Employee status: "<employeeStatus>"
    Examples:
      |name|surname|job       |dateOfBirth|gender|employeeStatus|
      |Jane|Doe    |Architect |02/01/1990 |female|employee      |
      |John|Doe    |Accountant|02/01/1985 |male  |employee      |