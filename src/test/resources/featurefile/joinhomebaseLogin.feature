Feature: Join Home Base Login and Other Scenarios related features

  @chrome @DemoTag
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


  @chrome @myScenario
  Scenario: Validate Forget Password flow when User enters Invalid Username or Password
    Given User Launch application home page
    When User enters "invalid" username in Username field
    And  User enters "invalid" password in password field
    When user click on sign In Page button for "invalid" credentials
    Then User validates error message for invalid credentials
    And User click on link to navigate the forget password flow


  @chrome @onboardingScenario @DemoTag
  Scenario Outline: Set Up A New Business as a Owner
    Given User Launch application home page
    When User click on sign up link on home page
    And User click on Set up a new business link
    Then User enters "<UserName>" username in the Username field
    And User select "<HowDidYouHearAboutUs>" from the dropdown list
    Then User click on Get Started button
    And User select "<WhatBringsYouToHomebase>" options
    Then User select "<HowDoYouCurrentlyRunPayroll>" from the dropdown list for payroll
    And User click on Continue button
    When User enters "<BusinessName>" in the business name field
    Then User enters "<ZipCode>" in the zip code field
    And User select "<TypeOfBusiness>" from the dropdown list for business type
    Then User select "<NumberOfEmployee>" from the list
    When User click One Last step button
    Then User enters "<Email>" in the email address field
    And User enters "<Password>" in the password field
    Then User enters "<PhoneNumber>" in the phone number field
    When User uncheck text me a link to the mobile app
    Then User click on continue to Homebase

    Examples:
      | UserName | Password    | Email             | PhoneNumber  | HowDidYouHearAboutUs   | WhatBringsYouToHomebase            | HowDoYouCurrentlyRunPayroll           | BusinessName |  ZipCode |  NumberOfEmployee | TypeOfBusiness       |
      | Alice  | Welcome123! | Roges123@abc.com   | 5559643290   | In the news            | Scheduling,Time Tracking,Payroll   | My business is new to running payroll | mycoffee98   |  77042   |  6-10             | Coffee Shop/Bakery   |


  @chrome @InvalidZip
  Scenario Outline: User validate error message for invalid zip code
    Given User Launch application home page
    When User click on sign up link on home page
    And User click on Set up a new business link
    Then User enters "<UserName>" username in the Username field
    And User select "<HowDidYouHearAboutUs>" from the dropdown list
    Then User click on Get Started button
    And User select "<WhatBringsYouToHomebase>" options
    Then User select "<HowDoYouCurrentlyRunPayroll>" from the dropdown list for payroll
    And User click on Continue button
    When User enters "<BusinessName>" in the business name field
    And User enters invalid "<ZipCode>" in the zip code field
    Then User validate error message "<errorMessage>" for invalid zip code entered


    Examples:
      | UserName | HowDidYouHearAboutUs   | WhatBringsYouToHomebase            | HowDoYouCurrentlyRunPayroll           | BusinessName |  ZipCode | errorMessage |
      | Alice    | In the news             | Scheduling,Time Tracking,Payroll   | My business is new to running payroll | Invalid   |  654654  |  Please use a valid US zip code, Canadian postal code, or UK postcode|


