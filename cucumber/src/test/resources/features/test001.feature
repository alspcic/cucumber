Feature: Check the google page

  Scenario: Simple scenario
    When I am on Google homepage
    Then I verify lucky button text
    And I enter some text in searchbox
    And I click search
    And I found something

  @debugs
  Scenario Outline: a new scenario outline
    Given I am on number page
    When I enter number: "<number>"
    And I click submit number
    Then I see message about number: "<message>"
  @working
    Examples:
      | number | message             |
      | 34     | Number is too small |
      | 101    | Number is too big   |

  @debugs
  Scenario Outline: a new scenario outline
    Given I am on number page
    When I enter number: "<number>"
    And I click submit number
    Then I see alert about number: "<message>"
  @working
    Examples:
      | number | message                   |
      | 51     | Square root of 51 is 7.14 |

    #ctrl + alt - arrange table
    #ctrl + /  - comment / uncomment

