Feature: Open Account
  @test
  Scenario: Add customer name and currency
    Given click open account
    And select customer name and currency
    And click process button
    Then navigate the popup page