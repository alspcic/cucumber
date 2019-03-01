Feature: Enter the number below, above and in between and verify error message.
  Scenario: square root of number between 50 and 100
    Given i am on a required page
    When i enter number in between 50 and 100
    And click on Submit button
    Then find out square root of it

  Scenario: verification of error message for a number below 50
    Given  i am a correct page
    When i enter number below 50
    And click on submit button
    Then i see error message

    Scenario: Verification of error message for a number above 100
      Given i am on corret page
      When  i enter number above 100
      And click on submit buttonn
      Then i see error messages