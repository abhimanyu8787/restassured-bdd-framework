#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Validate List Users API

  @ListUsersAPI
  Scenario Outline: Verify List Users API Response 
    Given List Users API with "<page>" and "<perPage>"
    When user calls "ListUsersAPI" API with GET http request
    Then verify if API returns with status code 200
    And verify API response against "ListUsers200ResponseSchema" schema
    
    Examples:
    |page	|perPage|
    |1		|10			|
    

