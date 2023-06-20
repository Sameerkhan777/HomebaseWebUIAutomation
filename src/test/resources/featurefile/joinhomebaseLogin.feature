Feature: Join Home Base Login and Other Scenarios related features

  @chrome
  Scenario: Login with valid credentials and verify Login is successful
    Given User Launch application home page
    When User enters username in Username field
    And  User enters password in password field
    Then user click on sign In Page button