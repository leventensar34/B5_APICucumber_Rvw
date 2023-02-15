#@wip
Feature: Sing Up

  Scenario Outline:DevEx user Register
    Given User creates a POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then Verify that status code should be 200
    Then Verify that body contains "token"
    And Compiler gets the token
    Examples:
      | email           | password | name | google     | facebook    | github     |
      | can05@gmail.com | Test1234 | Can1  | mertens QA | mertensbook | mertensgit |

  Scenario Outline: User should be able to send POST request get the token saves profile
    Given User creates a POST request and send the token with "<company>" "<webSite>" "<location>" "<status>" "<skills>" "<githubusername>" "<youtube>" "<twitter>" "<facebook>" "<linkedin>" "<instagram>"
    Then Verify that status code should be 200
    Then Verify that name "<name>" andemail as "<email>"
    Examples:
      | company | webSite       | location | status    | skills | githubusername | youtube      | twitter      | facebook      | linkedin      | instagram      | name | email           |
      | Apple   | www.apple.com | Virginia | Developer | AP UI  | appleGit       | AppleYoutube | AppleTwitter | AppleFacebook | AppleLinkedin | AppleInstagram | Can1  | can05@gmail.com |
