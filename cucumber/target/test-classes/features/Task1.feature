Feature: Task 1

  Scenario: Google page check
    When I navigate to 'https://www.google.com/' page
    Then I see 'Google Search button' on the page
      And I see 'Google Lucky button' on the page
      And I see 'Google image' on the page
