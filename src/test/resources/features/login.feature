Feature: Login

  Scenario: Successful login with parameters
    Given I sign in as "maria.laura.jorge1@gmail.com" has a password "xxxx"
    When I start session
    Then I should be Home

  Scenario: Wrong credentials
    Given I sign in as "laura.jorge1@gmail.com" has a password "xxxxxxx"
    When I try to login
    Then I should be rejected

  Scenario: Empty email
    Given I sign in as "" has a password "xxxxxxxx"
    When I try to login
    Then I should be rejected

  Scenario: Empty password
    Given I sign in as "maria.laura.jorge1@gmail.com" has a password ""
    When I try to login
    Then I should be rejected
