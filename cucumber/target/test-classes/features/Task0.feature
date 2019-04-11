Feature: Introduction to cucumber part 1
  Check the google page

  Scenario: Simple scenario
    When I am on Google homepage
    Then I verify lucky button text
    And I enter some text in searchbox
    And I found something