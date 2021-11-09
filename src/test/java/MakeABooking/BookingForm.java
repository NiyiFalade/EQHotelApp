package MakeABooking;

import org.openqa.selenium.By;

public class BookingForm {

    static By FIRSTNAME = By.id("firstname");
    static By SURNAME = By.id("lastname");
    static By TOTAL_PRICE = By.id("totalprice");
    static By DEPOSIT_PAID = By.id("depositpaid");
    static By CHECK_IN = By.id("checkin");
    static By CHECK_OUT = By.id("checkout");
    static By SAVE      = By.cssSelector("#form > div > div:nth-child(7) > input[type=button]");

}
