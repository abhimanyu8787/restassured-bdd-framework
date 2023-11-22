#Author: abhimanyukumar8787@gmail.com

Feature: Validate Peoplegrove API

@pgsignup
Scenario: Verify signup via email api
	Given Signup via Email with 'alumni' usertype
	When user calls "PgSignupAPI" with Post Http Request
	Then verify if API returns with status code 200
	When extract token from pg signup response
	And verify API response against "PGSignup200ResponseSchema" schema

@pglandingpage
Scenario: Verify get landing page template api
	Given Landing page settings api with version "-1"
	When user calls "PgLandingPage" API with GET http request
  Then verify if API returns with status code 200
  And verify the response of landing page template api
  
Scenario: Verify bottom banner section on landing page using API
	Given Signin as 'cluster admin' on pg standard
	Then verify if API returns with status code 200
	When extract token from pg signup response
	And modify 'bottom banner' settings in landing page template payload
	When user calls "PgLandingPageSettings" with Put Http Request
	Then verify if API returns with status code 200