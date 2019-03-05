@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: check adding people to a list
    Given I am on the people page
    When I press ADD PERSON button
    Then I am on the enter_a_new_person page
    When I enter name "<name>"
    And I enter surname "<surname>"
    And I enter job "<job>"
    And I enter dob "<dob>"
    And I enter english: "<english>"
    And I enter french: "<french>"
    And I enter spanish: "<spanish>"
    And I enter gender: "<gender>"
    And I enter employee status: "<option>"
    When I press ADD button
    Then List becomes longer to one
    And  The last person name is "<name>"
    And  The last person surname is "<surname>"
    And  The last person job is "<job>"
    And  The last person date of birth is "<dob>"
    And  The last person language is "<english>","<french>","<spanish>"
    And  The last person gender is "<gender>"
    And  The last person status is "<option>"
@working
Examples:
| name  | surname  | job        | dob        | english | french | spanish | gender | option     |
| Susan | Jons     | tester     | 02/12/2001 |  0      | 1      | 0       | female | contractor |
| Jon   | Smith    | programmer | 11/11/1995 |  1      | 1      | 0       | male   | contractor |