Feature: Log in feature of app to test
  whether the app allows to log in or not

Scenario: Valid Log in -1
  Given I am on the Go-Jek app log in page
  When I log in with "nishant@testvagrant.com" and password as "GoJek123"
  Then I should be able to see Go-Pay Balance

  Scenario: Valid Log in -1
    Given I am on the Go-Jek app log in page
    When I log in with "nishant@testvagrant.com" and password as "GoJek123"
    Then I should be able to see Go-Pay Balance
