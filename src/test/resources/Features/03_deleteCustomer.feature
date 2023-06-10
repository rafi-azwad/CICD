Feature: Delete Account

  @test
  Scenario: Customer information and delete customer
    Given user in customer page
    When search customer name
    And click delete button
    Then successfully go to home page