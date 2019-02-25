Feature: Add two person to People with jobs Page
  As a test engineer
  I want to add two people to the list and check the result

@test
  Scenario Outline: Add two person
    Given I am on the pwj homepage
       And I click Reset List button
    When I click on Add person button
    Then I am on the add a person page
       And I enter name: "<name>"
       And I enter surname: "<surname>"
       And I enter job: "<job>"
       And I choose birthday: "<dateofbirth>"
       And I choose know languages:
             | languOne | <languOne>|
             | languTwo | <languTwo>|
       And I choose gender
       And Employees status
    When I click Add button
    Then I am on the pwj homepagee
       And number of line bigger than three
       And I see new Name added to list: "<name>"

    Examples:
      | name  | surname     | job                  | dateofbirth  |languOne  |languTwo  |
      | Recep | Canbazlar   | Software Automation  | 02/08/1990   |English  |Spanish  |
      | Tayyo | Eryo        | Teacher              |11/08/1980    |Spanish  |English  |