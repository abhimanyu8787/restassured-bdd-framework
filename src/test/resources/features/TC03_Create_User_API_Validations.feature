#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Validate Create User API

  @CreateUserAPI
  Scenario Outline: Verify Create User API Response
    Given Create User API with "<name>" and "<job>"
    When user calls "CreateUserAPI" with Post Http Request
    Then verify if API returns with status code 201
    And verify API response against "CreateUser200ResponseSchema" schema
    
  Examples:
  |email							|password			|
  |abhimanyu					|co founder		|
  |anubhi							|co founder		|