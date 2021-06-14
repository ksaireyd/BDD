Feature: Smoke
  As a user
  I want to have possibility to send letters
  So that I can be sure that i will be able to communicate with peoples


  Scenario Outline: Check signing in
    Given User opens signing page
    And User enter his '<email>'
    And User enter his '<password>' key
    Then User gets to the home page
    And User clicks compose
    And User enters '<sendto>' field
    And User enters '<text>' of message
    And User sends message
    When User opens sent folder
    Then User confirms sending
    And User deletes the letter from folder

    Examples:
      |email             |password   |sendto|text|
      |test2.1.2.2.w@gmail.com|qwertyip1|my.test.0.0.1.00@gmail.com|hello|
      |tesqi12s1d@gmail.com|Zaqwsx12    |my.test.0.0.1.00@gmail.com|hello2|