#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Validate Register User API

  @RegisterUserAPI
  Scenario Outline: Verify Register User API Response
    Given Register User API with "<email>" and "<password>"
    When user calls "RegisterUserAPI" with Post Http Request
    Then verify if API returns with status code 200
    And verify API response against "CreateUser200ResponseSchema" schema
    
  Examples:
  |email							|password			|
  |eve.holt@reqres.in	|password123	|
  
  @LoginUserAPI
  Scenario Outline: Verify Login Functionality for Registered User
  	Given Login API with "<email>" and "<password>"
  	When user calls "LoginAPI" with Post Http Request
  	Then verify if API returns with status code 200
    And verify API response against "LoginUser200ResponseSchema" schema
    And verify if login is successful and token "QpwL5tke4Pnpja7X4" is returned
    
  Examples:
 	|email							|password			|
  |eve.holt@reqres.in	|password123	|

  