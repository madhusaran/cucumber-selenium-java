@demo
Feature: API Test - Example for downstream validation using API

  Scenario: Login user via API
    Given I send a POST request to "/users/login"
    Then the response code should be 200
    And response should contain the key "token"

  Scenario: GET contact detail via API
    Given I send a GET request to "/contacts" with token
    Then the response code should be 200
    And response should contain the key "_id"
