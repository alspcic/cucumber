Feature: Google

  Scenario: simple scenario
    Given I am on google page
    When I verify Google search button text
    And I verify google lucky button text
    Then I should see google image