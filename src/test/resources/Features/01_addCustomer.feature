Feature: Bank Manager Login

  @test
  Scenario Outline: Add customer with valid data
    Given manager to the add customer page
    When click bank manager login
    And select add customer button
    And manger enters '<firstName>' and '<lastName>' and '<postCode>'
    And click add customer button
    Then manager will navigate to successful popup page

    Examples:
      | firstName | lastName | postCode |
      | Rafi      | Azwad    | 2200     |
