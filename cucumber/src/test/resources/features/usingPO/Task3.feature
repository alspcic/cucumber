Feature: Introduction to cucumber part 2, Task 3
#  1. Create page object for "People with jobs list"
#  2. Press on add a new button
#  3. Create page object for "Adding new person" page
#  4. Fill all required data
#  5. Add two languages using data table
#  6. Verify that amount of user is now 4
#  7. Delete last created user

  Scenario: Create a new person on the List of person page
    Given I am on people with jobs page using PO
    And I click "add a new" button using PO
    And I fill the form using PO
      | Name | Surname | Job | DOB        | Language | Gender | Employee_Status |
      | Max  | Wax     | QA  | 11/02/1999 | english  | Male   | employee        |
    And I click Add button using PO
    And I click "add a new" button using PO
    And I fill the form using PO
      | Name | Surname | Job | DOB        | Language | Gender | Employee_Status |
      | Juli | Watson  | DEV | 11/02/1999 | french   | female | contractor      |
    And I click Add button using PO
    Then I check that table contains "4" records using PO
    Then I delete last created user using PO


