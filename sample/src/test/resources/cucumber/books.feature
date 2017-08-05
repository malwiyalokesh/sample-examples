Feature: User makes a call on /books!
  Scenario: User makes call to /books
    Given User calls GET on /books
    Then the response status is 200
    And the number of books returned is 4