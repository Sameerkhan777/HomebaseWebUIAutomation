Feature: Join Home Base Login and Other Scenarios related features

  @chrome
  Scenario: Login with valid credentials and verify Login is successful
    Given User Launch application home page
    When User enters "valid" username in Username field
    And  User enters "valid" password in password field
    Then user click on sign In Page button for "valid" credentials


  @chrome
  Scenario: Login with Invalid credentials and verify error message for invalid credentials
    Given User Launch application home page
    When User enters "invalid" username in Username field
    And  User enters "invalid" password in password field
    When user click on sign In Page button for "invalid" credentials
    Then User validates error message for invalid credentials


  @chrome
  Scenario: Login with

