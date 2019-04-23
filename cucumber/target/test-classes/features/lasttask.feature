#1. Create page object for "People with jobs page"
#2. Press on add a new button
#3. Create page object for "Adding new person" page
#4. Fill all required data
#5. Add two languages using data table
#6. Verify that amount of user is now 4
#7. Delete last created user

  Feature: People list
    Scenario: Add new Person
      Given I am on People list page
      When I click on add new Person button
      And I enter Name : "Hend"
      And I enter Surname : "Ali"
      And I enter Job : "Tester"
      And Date Of Birth: "08/14/1986"
      And I select languages :
      |English |
      |French  |
      And I select Gender:
      |Female|
      And I select Employee Status:
      |Employee|
      And I click on Add button
      And Number of users is now : "4"
#      When I delete last user added
#      Then it is no longer on page with name :"Hend"
