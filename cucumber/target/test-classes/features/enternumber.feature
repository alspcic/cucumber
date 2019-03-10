Feature: enter number

  Scenario Outline: Error message check
    Given I am on Enter a number page
    When I enter numbers:"<number>"
    And I click button Submit
    Then I receive message:"<message>"

    Examples:
    |number|message            |
    |40    |Number is too small|
    |101   |Number is too big  |


   Scenario Outline: Correct value check
     Given I am on Enter a number page
     When I enter numbers:"<number>"
     And I click button Submit
     Then I receive pop-up message:"<message>"

     Examples:
       | number | message                     |
       | 50     | Square root of 50 is 7.07   |
       | 100    | Square root of 100 is 10.00 |
       | 81     | Square root of 81 is 9.00   |