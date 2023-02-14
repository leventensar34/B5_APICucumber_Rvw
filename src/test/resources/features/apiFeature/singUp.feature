@wip
Feature: Sing Up

  Scenario Outline:DevEx user Register
    Given User creates a POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then Verify that status code should be 200
    Then Verify that body contains "token"
    Examples:
      | email | password | name | google | facebook | github |
      | GsQa1mertens@gmail.com | Test1234 | Mertenss | mertens QA | mertensbook | mertensgit |