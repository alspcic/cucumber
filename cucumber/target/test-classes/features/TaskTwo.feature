Feature: Introduction to cucumber part 1
  
  Scenario: Submit number without number
    Given I am on enter number page
   And I click submit button
   Then I see message: "You haven't entered anything"

    Scenario: Submit a number
      Given I am on enter number page
      And I enter my number: 6
      And I click submit button
      Then I see error message: "Number is too small"



  Scenario Outline: Entering enter number page
    Given I am on enter number page
    And I enter my number: "<number>"
    And I click submit button
  Then I see error message: "<message>"

  Examples:
   | number | message             |
   | 33     | Number is too small |
   | 112    | Number is too big   |
