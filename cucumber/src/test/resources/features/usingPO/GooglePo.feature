Feature: Introduction to cucumber part 1
  Check the google page using PO

  Scenario: Simple scenario
    When I am on Google homepage using PO
    Then I verify lucky button text using PO
    And I enter some text in searchbox using PO
    And I found something using PO