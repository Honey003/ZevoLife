Feature: Automation ZEVO 

Background: User is Logged In 

	Given User is on landing page"https://qa.zevolife.com/" 

	
Scenario: Login in Zevo Applications
	Then add user name
	And Password
	Then Verify user logged in the application
	And close the browser