Feature: Sanity Test

  @TestCase001
  Scenario: CreateHTMLReport
    Given Make initial setup

  Scenario Outline: PlayerEnrolment
    Given Test Case ID is "TestCase_001"
    Given Create New Line of Test Result with "Player Enrolment", "", "" and ""
    Given Launch HALo url in "Chrome" browser
    When Login as <User> user
    Then Check login sucessfull
    Then Enroll <No_Of_Players> <PlayerType> Player
    Then Property play PopUp
    Then Update Account type in CMS Property :<User> and Player Type :"C""
    Then Logout
    Then User close browser

    Examples: 
      | User | No_Of_Players | PlayerType  |
      | "IP" |             1 | "Marketing" |
