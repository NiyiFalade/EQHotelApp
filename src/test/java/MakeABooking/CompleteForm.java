package MakeABooking;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class CompleteForm {

    public static Performable hotelForm(String firstName, String lastName, String Price, String deposit, String checkIn, String CheckOut) {
        return Task.where(" complete the form",
                Enter.theValue(firstName).into(BookingForm.FIRSTNAME),
                Enter.theValue(lastName).into(BookingForm.SURNAME),
                Enter.theValue(Price).into(BookingForm.TOTAL_PRICE),
                SelectFromOptions.byVisibleText(deposit).from(BookingForm.DEPOSIT_PAID),
                Enter.theValue(checkIn).into(BookingForm.CHECK_IN),
                Enter.theValue(CheckOut).into(BookingForm.CHECK_OUT)
        );
    }

    public static Performable saveForm() {
        return Task.where("saving the form",
                Click.on(BookingForm.SAVE)
        );
    }
}
