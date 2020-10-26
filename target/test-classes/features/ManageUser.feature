Feature: Mange User

Background: User is Logged In 

	Given User is on landing page"https://qa.zevolife.com/" 

	Scenario: Create User
	Then User login the application
	And Click on the Manage User menu
	Then Fill the desired information and submit 
	And Validate the record is updated