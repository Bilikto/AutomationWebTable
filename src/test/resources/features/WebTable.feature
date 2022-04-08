Feature: This feature file is to test Web table

  Background:
  Given open web table

  @Smoke
  Scenario: verify User can be added to the web table
    When add a new user to the web table
    Then verify the user has been added to the web table

  @Smoke
  Scenario: verify User can be removed from the web table
    When delete user with User Name: novak from the web table
    Then verify user has been deleted from the web table
