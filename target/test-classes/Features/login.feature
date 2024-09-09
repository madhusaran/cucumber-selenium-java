Feature: Login

  @demo
  Scenario Outline: Verify Login Flow
    Given when user navigate to login page
    When user enter the "<username>" and "<password>"
    And user click the login button
    Then validate that user is landed on home page and see welcome messgae

    Examples: 
      | username | password    |
      | student  | Password123 |
