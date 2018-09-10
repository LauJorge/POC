Feature: New Repository

  Scenario: Access to Create a repository
    Given I am logged in Github as "maria.laura.jorge1@gmail.com" and password "bnmbnm123"
    And I am logged
    When I click on the start new repository
    Then I should see the Create Repository Page

  Scenario: Create a new Repository
    Given I am logged in Github as "maria.laura.jorge1@gmail.com" and password "bnmbnm123"
    And I am logged
    And I am on the Create Repository Page
    And I write as repository name "Test New Repository"
    When I submit the new repository
    Then I should see my repository created

  Scenario: Create a new Repository with description
    Given I am logged in Github as "maria.laura.jorge1@gmail.com" and password "bnmbnm123"
    And I am logged
    And I am on the Create Repository Page
    And I write as repository name "Test New Repository"
    And I write a repostirory description
    When I submit the new repository
    Then I should see my repository created

  Scenario: Create a new Repository initialized with a README
    Given I am logged in Github as "maria.laura.jorge1@gmail.com" and password "bnmbnm123"
    And I am logged
    And I am on the Create Repository Page
    And I write as repository name "Test New Repository"
    And I select initialize with readme
    When I submit the new repository
    Then I should see my repository created