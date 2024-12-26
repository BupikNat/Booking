package pages;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage {

    SearchPage searchPage;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void bookingSearchPageIsOpened() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.booking.com/searchresults.en-gb.html");
        searchPage = new SearchPage(driver);
    }

    public void userSearchesFor(String hotel) {
        driver.findElement(By.xpath("//input[@name = 'ss']")).sendKeys(hotel);
        driver.findElement(By.cssSelector("button[type=submit]")).click();
    }

    public void hotelIsShown(String expectedResult) {
        List<WebElement> titles = driver.findElements(By.xpath("//*[@data-testid='title']"));
        boolean isHotelFound = false;
        for (WebElement title : titles) {
            if (title.getText().equals(expectedResult)) {
                isHotelFound = true;
                break;
            }
        }
        Assert.assertTrue(isHotelFound);
    }

    public void ratingOfHotel(String expectedResult) {
        List<WebElement> ratings = driver.findElements(By.xpath("//div[@data-testid='review-score']//following::*[text() = 'Оценка 9,1']"));
        boolean isNeededRating = false;
        for (WebElement rating : ratings) {
            if (rating.getText().equals(expectedResult)) {
                isNeededRating = true;
                break;
            }
        }
        Assert.assertTrue(isNeededRating);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}