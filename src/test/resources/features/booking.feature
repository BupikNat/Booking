Feature: Search a hotel

  Scenario: Loking for 'Akra Kemer Hotel'
    Given booking search page is opened
    When user searching for "Akra Hotel"
    Then "Akra Kemer - Ultra All Inclusive" hotel is shown
    And hotel has rating "Оценка 9,1"

  Scenario Outline: Loking for 'Akra Kemer Hotel'
    Given booking search page is opened

    Examples:
      | hotel         | expectedresult                   |
      | Akra Kemer    | Akra Kemer - Ultra All Inclusive |
      | Meraki Resort | Meraki Resort - Adults Only      |
