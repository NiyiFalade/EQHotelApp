package Navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable hotelHomePage() {
        return Task.where("{0} opens the hotel booking app",
                Open.browserOn().the(HotelAppHomePage.class)
        );
    }


}