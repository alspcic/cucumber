Feature:

  Scenario Outline: Number page
    Given I am on number entered page
    When I see header page
    And I enter the number: "<number>"
    And I click button Submit
#    And I see message: "<message>"


    Examples:
      | number | message             |
      | 43     | Number is too small |
      | 64     | Answer              |
      | 111    | Number is too big   |
