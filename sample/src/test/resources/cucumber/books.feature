Feature: User makes a call on /books!
  Scenario: Server reply version
    Given I call GET on /version
    Then the response status is 200
    And the response body must contain message with 1.0