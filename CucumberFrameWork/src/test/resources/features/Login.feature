Feature: Login

  Scenario Outline: Login to HRM Application
    Given User is Opening the Browser
    When User Login Using Username "<username>" and Password "<password>"
    And click on Login button
    Then redirected to HRM Home page

  Examples: 
    | username | password  |
    | Admin    | admin123  |
