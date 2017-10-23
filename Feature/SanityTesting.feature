Feature: Sanity Test

  Scenario: CreateHTMLReport
    Given Make initial setup   

			
  Scenario Outline: Enrollment  	
    Given Create New Line of Test Result with "Player Enrollment", "", "" and ""
    Given Launch HALo url in "Chrome" browser
    When Login as <User> user
    Then Check login sucessfull
    Then Enroll <No_Of_Players> <PlayerType> Player
    Then Property play PopUp
    Then Logout
    Then User close browser
    
    Examples: 
      | User   | No_Of_Players | PlayerType  |
      | "IP"   |             1 | "Marketing" |
      

  Scenario: Adjust Player Enrollment
    Given Create New Line of Test Result with "Adjust Player Enrollment", "", "" and ""
    Given Launch HALo url in "Chrome" browser
    When Login as "IP" user
    Then Check login sucessfull
    Then Enroll "1" "Marketing" Player
    Then Adjust Player Tier level to "SAPPHIRE" with lock type as "None"
    Then Property play PopUp
    #Then Push Player to "SC"
    #Then Property play PopUp
    Then Logout
    
  

  Scenario: Push Player Enrollment
    Given Create New Line of Test Result with "Push Player Enrollment", "", "" and ""
    Given Launch HALo url in "Chrome" browser
    When Login as "IP" user
    Then Check login sucessfull
    Then Enroll "1" "Marketing" Player
    Then Property play PopUp
    Then Push Player to "IP Biloxi"
    Then Property play PopUp
    Then Logout
    Then User close browser   

  Scenario: Property Play Pop Up
    Given Create New Line of Test Result with "Adjust Player Enrollment", "", "" and ""
    Given Launch HALo url in "ie" browser
    Then Login as "IP" user
    Then Enroll "1" "Marketing" Player
    Then Property play PopUp
    #Then Push Player to "IP-Biloxi"
    #Then Property play PopUp
    Then Adjust Player Tier level to "SAPPHIRE" with lock type as "None"
    Then Property play PopUp
		Then Logout
    
    Scenario: Final Report Generation
    	Given Final Report Generation