
Feature: Retrieve Profile

  Scenario: User able to see all profile
    Given User creates a GET request and able to see all profiles
    Then Verify that status code is 200


  Scenario: User able to see all profiles second way
    Given User creates a GET request and able to see all profiles second way
    Then Verify that status code is 200


  Scenario Outline: GET request with path param
    Given User creates a GET request with pat "<id>"
    Then Verify that status code is 200
    Then Verify that user info's "<name>" and "<email>" and "<company>" and "<location>"
    Examples:
      | id  | name             | email                    | company  | location |
      | 236 | Mike Masters     | etsMntr@eurotech.com     | eurotech | Germany  |
      | 17  | GOKHAN YILDIRIM  | gokhanyildirim@gmail.com | Siemens  | Ankara   |
      | 36  | Anderson Talisca | talisca@gmail.com        | Al-Hilal | Riyad    |