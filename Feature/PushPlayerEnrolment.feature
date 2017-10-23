Feature: HALo Verification 

@PushPlayerEnrollment
	Scenario: PlayerTierLevelEnrollment 	
  	Given Make initial setup
    Given Launch HALo url in "Chrome" browser
    When Login as "STLV" user    
    Then Check login sucessfull
    Then Enroll "1" "Marketing" Player
    Then Push Player to "IP Biloxi"
    Then Logout
    Then User close browser 