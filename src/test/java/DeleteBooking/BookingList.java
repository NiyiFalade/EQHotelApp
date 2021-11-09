package DeleteBooking;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.List;

public class BookingList {

    public static Question<List<String>> Bookings() {
        return actor -> TextContent.of(Bookings.BOOKINGS).viewedBy(actor).asList();
    }
}
