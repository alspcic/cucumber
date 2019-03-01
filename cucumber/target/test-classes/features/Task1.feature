Feature: Checking Google chrome page


  Scenario: Simple scenario
    Given i am on the google page
    When I verify google search button
    And I verify google lucky button text
    And i should see google image
    Then I enter "demo" text in search field
    And press Google search button
