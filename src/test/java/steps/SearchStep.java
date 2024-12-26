package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchStep {

    WebDriver driver;
    SearchPage searchPage;

    @Given("booking search page is opened")
    public void bookingSearchPageIsOpened() {
        searchPage.bookingSearchPageIsOpened();
    }

    @When("user searches for {string}")
    public void userSearchesFor(String hotel) {
        searchPage.userSearchesFor("Akra Kemer");
    }

    @Then("{string} hotel is shown")
    public void hotelIsShown(String expectedResult) {
        searchPage.hotelIsShown("Akra Kemer - Ultra All Inclusive");
    }

    @And("hotel has rating {string}")
    public void ratingOfHotel(String expectedResult) {
        searchPage.ratingOfHotel("Оценка 9,1");
    }
}