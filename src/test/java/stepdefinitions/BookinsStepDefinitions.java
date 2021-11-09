package stepdefinitions;

import DeleteBooking.BookingList;
import DeleteBooking.Bookings;
import MakeABooking.BookingForm;
import MakeABooking.CompleteForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Navigation.NavigateTo;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnElement;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.locators.WaitForWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.log.Log;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.everyItem;

public class BookinsStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the hotel booking APP")
    public void userIsOnTheHotelBookingAPP(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.hotelHomePage());
    }

    @Then("hotel booking is created")
    public void hotelBookingIsCreated() {
        theActorInTheSpotlight().attemptsTo(
                CompleteForm.saveForm()
        );
    }

    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersFirstnameAndSurnameAndPriceAndDepositAndCheckinAndCheckoutDate(String firstName, String lastName, String price, String deposit, String checkIn, String checkOut) {
        theActorInTheSpotlight().attemptsTo(
                CompleteForm.hotelForm(firstName, lastName, price, deposit, checkIn, checkOut)
        );
    }

    @When("user deletes booking with {string} and {string} and {string} and {string} and {string} and {string}")
    public void userDeletesBookingWithAndAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws InterruptedException {

        BrowseTheWeb.as(theActorInTheSpotlight()).waitForTextToAppear("Hotel booking form").waitFor(5).second();

        int bookingNumber = 0;

        List<WebElementFacade> bookings = BrowseTheWeb.as(theActorInTheSpotlight()).findAll(By.xpath("//*[@id='bookings']/div"));
        for (WebElementFacade booking : bookings) {
            if (booking.getText().contains(arg0 + "\n" + arg1 + "\n" + arg2)) {
                bookingNumber = Integer.parseInt(booking.getAttribute("id"));
            }
        }
        theActorInTheSpotlight().attemptsTo(
                Click.on(By.xpath("//input[@type='button' and @onclick='deleteBooking(" + bookingNumber + ")']"))
        );
    }

    @Then("booking application with {string} and {string} is deleted")
    public void bookingApplicationIsDeleted(String firstname, String lastname) {

        Boolean isDeleted = true;
        List<WebElementFacade> bookings = BrowseTheWeb.as(theActorInTheSpotlight()).findAll(By.xpath("//*[@id='bookings']/div"));
        for (WebElementFacade booking : bookings) {
            if (booking.getText().contains(firstname + "\n" + lastname)) {
                isDeleted = false;
            }
        }

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(isDeleted).isTrue()
        );
    }

}
