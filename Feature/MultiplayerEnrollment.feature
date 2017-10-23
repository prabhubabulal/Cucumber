Feature: HALo Verification

  Scenario: CreateHTMLReport
    Given Make initial setup
    Given Create New Line of Test Result with "MultiplayerEnrollment - Player ", "", "" and ""

  Scenario Outline: MultiPlayerEnrolment
    Given Launch HALo url in "ie" browser
    When Login as <User> user
    Then Check login sucessfull
    Then Enroll <No_Of_Players> <PlayerType> Player
    Then Logout
    Then User close browser

    Examples: 
      | User   | No_Of_Players | PlayerType  |
      | "STLV" |             1 | "Marketing" |
