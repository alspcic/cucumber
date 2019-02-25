Feature: Verify google page
  As a test engineer
  I want to assert objects in google home page

@test
  Scenario: Simple scenario
    Given I am on the google homepage
    Then I should see Google Search in the button
    Then I should see I'm Feeling Lucky in the button
    And I should see google image visible