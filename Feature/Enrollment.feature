Feature: Enrollment test Cases

  Scenario: CreateHTMLReport
    Given Make initial setup
    Given Launch HALo url in "Chrome" browser
    When Login as "IP" user
    Given Launch BConnected url in "Chrome" browser
    Given Create New Line of Test Result with "BConnected Enrollment", "", "" and ""

  Scenario Outline: BConnectedEnrollment
    Given Number of Users <User>
    Then Enroll "1" <PlayerType> Player
    Then Enroll Player in BConnected

    Examples: 
      | User   | PlayerType  |
      | "IP" | "Marketing" |
     
