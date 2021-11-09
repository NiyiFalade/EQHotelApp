Feature: Create/Delete Hotel Booking
  As a user of the Hotel Booking system
  I should be able to see create and delete a hotel booking

  @test
  Scenario Outline: create a booking
    Given user is on the hotel booking APP
    When user enters "<firstname>" and "<surname>" and "<price>" and "<deposit>" and "<checkin>" and "<checkoutDate>"
    Then hotel booking is created

    Examples:
      | firstname | surname | price | deposit | checkin | checkoutDate |
      | Mark      | Henru   | 100   | false    | 2021-11-10 | 2021-11-14   |


  @test
  Scenario Outline: Delete a booking
    Given user is on the hotel booking APP
    When user deletes booking with "<firstname>" and "<surname>" and "<price>" and "<deposit>" and "<checkin>" and "<checkoutDate>"
    Then booking application with "<firstname>" and "<surname>" is deleted
    Examples:
      | firstname | surname | price | deposit | checkin | checkoutDate |
      | Mark      | Henru   | 100   | false    | 2021-11-10 | 2021-11-14   |


