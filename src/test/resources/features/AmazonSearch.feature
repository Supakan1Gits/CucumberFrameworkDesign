
@tag
Feature: Amazon search
  I want to use this template for my feature file

  @tamazonSearchTest
  Scenario Outline: Search Items on Amazon
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
