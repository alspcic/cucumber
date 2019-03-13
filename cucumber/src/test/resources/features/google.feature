Feature: Introduction to cucumber

  Scenario: Simple scenario
    Given I am on the Google page
    When I verify Google Search button text
    And I verify google lucky button text
    And I should see google image
    Then I enter: "demo" text in search field
    And press Google search button


#  Scenario Outline: Verify error messages
#     Given I am on the task page
#     And I enter number <number>
#     And I click the Submit button
#     Then I verify message <message>
#
#    Examples: Inputs
#    |number|message|
#    |      |You haven't entered anything|
#    |48    |Number is too small         |
#    |101   |Number is too big           |
#
#
#   Scenario: Verify pop-up messages
#     Given I am on the task page
#     And I enter "50"
#     When I click the Submit button
#     Then a confirmation box saying "Square root of 100 is 10.00"
