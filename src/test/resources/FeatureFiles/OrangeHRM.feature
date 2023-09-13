Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User is on given url
    And User enters username and password
    And User wait for 1 seconds
    And User click on Login button
    And User wait for 4 seconds

    Examples: 
      | username | password |
      | Admin    | admin123 |

  @BuzzPost
  Scenario: Post something on Buzz Newsfeed
    Given User is on given url
    And User enters username and password
    And User wait for 1 seconds
    And User click on Login button
    And User wait for 4 seconds
    When User click on Buzz item
    And User wait for 2 seconds
    And User click on Share Photos button
    And User wait for 1 seconds
    And User writes a message
    And User wait for 1 seconds
    When User click on upload image button
    And User wait for 1 seconds
    And User click on Share button
    And User wait for 1 seconds

  @AddAdminUser
  Scenario: Creation of new Admin user
    Given User is on given url
    And User enters username and password
    And User wait for 1 seconds
    And User click on Login button
    And User wait for 3 seconds
    When User click on Admin Page
    And User wait for 1 seconds
    When User click on add user button
    And User wait for 1 seconds
    And User select "ESS" user
    And User wait for 1 seconds
    And User enters employee name "Virat Kohli"
    And User wait for 1 seconds
    And User enters username "John123"
    And User wait for 1 seconds
    And User select status as "Enabled"
    And User wait for 1 seconds
    And User enters password and confirm password as "Test@123"
    And User wait for 2 seconds

  @AddEmployee
  Scenario: Adding new employee from PIM page
    Given User is on given url
    And User enters username and password
    And User wait for 1 seconds
    And User click on Login button
    And User wait for 3 seconds
    When User click on PIM Page
    And User wait for 1 seconds
    When User click on add employee button
    And User wait for 1 seconds
    And User enters first name, middle name, and last name
    And User clicks on save button
    And User wait for 2 seconds
