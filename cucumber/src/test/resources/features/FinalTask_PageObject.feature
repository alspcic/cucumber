Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario
  Scenario: As a user I want to create 1 add one new user to list of employee.
    Given i am on the page
    When i click on Add person
    Then another webpage open with title People with jobs
    When I enter Names
    When I enter surname
    When I enter job
    When i select date of birth
    When i chose check box 1 and 3
    When i select gender as male
    When i select employee status from the drop down list
    When i click on Add button
    Then the record of employee add successfully and return me to main page
    Then i see the employee detail in list of employees





