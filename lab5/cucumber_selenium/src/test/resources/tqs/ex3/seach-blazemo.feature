Feature: Search in BlazeDemo

  Background:
    When I navigate to 'https://blazedemo.com/'

  Scenario: Seek Flights from 'Boston' to 'Dublin'
    And I select my departure city 'Boston'
    And I select my destination city 'Dublin'
    And I press 'Find Flights'
    Then I see a list of 'Flights from Boston to Dublin'

  Scenario: Seek Flights from 'Portland' to 'New York'
    And I select my departure city 'Portland'
    And I select my destination city 'New York'
    And I press 'Find Flights'
    Then I see a list of 'Flights from Portland to New York'
    And I press 'Choose This Flight'
    And I enter my details
    And I press 'Purchase Flight'
    Then The purchase should be confirmed and cost 555