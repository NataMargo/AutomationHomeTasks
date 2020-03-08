
Feature: cucumber_practice
Login on the Linkedin

  Background: User open the home page at https://www.linkedin.com/home


Scenario: Login with invalid data
    When I fill in Email with " "
    And I fill in Password with " "
    And I click on the Log In button
    Then I should see Warning message


Scenario: Successful login
   When I fill in Email with "larusbiz@gmail.com"
    And I fill in Password with "4113888"
    And I click on the Log In button
    Then I am on the My profile page on URL "https://www.linkedin.com/feed/"



