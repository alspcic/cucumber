@google

Feature: Enter number in Google search

  Scenario: Simple scenario
    Given I am on Google page
    When I verify Google Search button text
    And I verify google lucky button
    And I should see google picture
    When I input value "5" in search
    And I click click button search
    Then I am able to see search results