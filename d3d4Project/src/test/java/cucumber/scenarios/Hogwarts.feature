@tag
Feature: Hogwarts
  Background:
		User navigates to Hogwarts home page

  @tag1
  Scenario: Verify home page set up
    Given I am on home page
		Then Teams button is available
		And Gryffindor team is shown to user
		And Hufflepuf team is shown to user
		And Ravenclaw team is shown to user
		And Slytherin team is shown to user

  @tag2
  Scenario: Verify Gryffindor Dashboard url
    When I click on Gryffindor team
		Then Dashboard url is available for user
		
		@tag3
  	Scenario: Verify Gryffindor Alert Window behavior
    Then Alert window is shown to user
		And Alert window contains Gryffindor Dashboard JSON response info

