Feature: Introduction to cucumber part 1
  Check the google page using PO

  Scenario: Scenario with PO for Google web page
    When I am on Google homepage using PO
    Then I verify lucky button text using PO
    And I enter some text in searchbox using PO
    And I found something using PO



  Scenario Outline: a new scenario outline with PO for Kristina web site
    Given I am on enter a number page using PO
    When I enter "<number>" using PO
    Then I check invalid "<number>" using PO
    And I click "submit" button using PO
    Then I see warning message: "<message>" using PO
  @working
    Examples:
      | number | message             |
      | 43     | Number is too small |
      | 101    | Number is too big   |
