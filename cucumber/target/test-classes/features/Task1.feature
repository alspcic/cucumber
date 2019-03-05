Feature: Test for roadmap

  Scenario: testing google
    Given I am on Google page
    When I verify search button text
    And I verify lucky button text
    And I should see google image