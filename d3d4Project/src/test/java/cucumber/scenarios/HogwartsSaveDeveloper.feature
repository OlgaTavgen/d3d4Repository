@tag
Feature: Hogwarts Save Developer
  Background:
		User navigates to Hogwarts Save Developer Page

  @tag1
  Scenario: Verify Save Developer button is present
    Given I am on Save Developer page
    Then Save Developer button is available
    
    @tag2
    Scenario: Verify Save Developer operation
    	When I click on Save Developer button
    	Then Alert window is shown to user
    	And Alert window says that Hogwarts Developer is saved
    	
