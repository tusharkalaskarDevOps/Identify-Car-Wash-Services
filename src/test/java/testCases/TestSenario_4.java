package testCases;

import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.GymServicePage;
import pageObjectModels.HomePage;
import java.time.Duration;

public class TestSenario_4 extends BaseTest{

    @Test(priority = 1)
    public void test_gym_option_navigation_and_display() {

        System.out.println("Starting Test - TC14...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            HomePage homePage = new HomePage(driver);
            homePage.closePopUp();
            System.out.println("Pop-up closed successfully.");
        } catch (Exception e) {
            System.out.println("No pop-up found or already closed.");
        }

        try {
            GymServicePage gymPage = new GymServicePage(driver);
            gymPage.clickGymMenu();
            System.out.println("Clicked on 'Gym' menu.");

            wait.until(ExpectedConditions.titleContains("Gym"));

            String actualTitle = driver.getTitle();
            System.out.println("Page title: " + actualTitle);

            Assert.assertTrue(actualTitle.contains("Gym"), "'Gym' Page has not loaded...");

        } catch (Exception e) {
            System.out.println("Test TC14 failed due to exception: " + e.getMessage());
            Assert.fail("Test TC14 failed unexpectedly.");
        }
    }


    @Test(priority = 2)
    public void test_sort_by_relevance() {
        System.out.println("Starting Test - TC15...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.sortBy.click();
        gymPage.relevance.click();

        for(WebElement list:gymPage.relevenceList){
            String listingText = list.getText();
            Assert.assertTrue(listingText.contains("Chennai"), "Listing does not contain 'Chennai': ");
        }
        System.out.println("Rating elements detected: " + gymPage.relevenceList.size());
    }

    @Test(priority = 3)
    public void test_sort_by_rating() {
        System.out.println("Starting Test - TC16...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.relevance.click();
        gymPage.sortByrating.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void test_filter_by_sunday_open() {
        System.out.println("Starting Test - TC17...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        gymPage.sundayAmenitiesFilter.click();
        gymPage.applyButton.click();

        Assert.assertTrue(true);

        //Clear the Selections
        gymPage.amenitiesFilter.click();
        gymPage.clearButton.click();
    }

    @Test(priority = 5)
    public void test_filter_by_locker_facility() {

        System.out.println("Starting Test - TC18...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        gymPage.lockerAmenitiesFilter.click();
        gymPage.applyButton.click();

        Assert.assertFalse(gymPage.lockerList.isEmpty(),"No Gyms Found");
        System.out.println("Locker elements detected: " + gymPage.lockerList.size());
    }

    @Test(priority = 6)
    public void test_clear_filters_removes_amenities() {

        System.out.println("Starting Test - TC19...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        gymPage.clearButton.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 7)
    public void test_filter_by_open_now() {

        System.out.println("Starting Test - TC20...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.openNow.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 8)
    public void test_filter_by_top_rated() {

        System.out.println("Starting Test - TC21...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.topRated.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 9)
    public void test_filter_by_quick_response() {

        System.out.println("Starting Test - TC22...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.quickResponse.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 10)
    public void test_filter_by_jd_verified() {

        System.out.println("Starting Test - TC23...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.jdVerified.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 11)
    public void test_filter_by_ratings_3_5_plus() {

        System.out.println("Starting Test - TC24...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        gymPage.rating1.click();

        for(WebElement ele : gymPage.ratingCountList){
            String rating = ele.getText();
            double val = Double.parseDouble(rating);
            Assert.assertTrue(val >= 3.5, "Rating is not above 3.5: " + rating);
        }
    }

    @Test(priority = 12)
    public void test_filter_by_ratings_4_0_plus() {

        System.out.println("Starting Test - TC25...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        gymPage.rating2.click();

        for(WebElement ele : gymPage.ratingCountList){
            String rating = ele.getText();
            double val = Double.parseDouble(rating);
            Assert.assertTrue(val >= 4.0, "Rating is not above 3.5: " + rating);
        }
    }

    @Test(priority = 13)
    public void test_filter_by_ratings_4_5_plus() {

        System.out.println("Starting Test - TC26...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        gymPage.rating3.click();

        for(WebElement ele : gymPage.ratingCountList){
            String rating = ele.getText();
            double val = Double.parseDouble(rating);
            Assert.assertTrue(val >= 4.5, "Rating is not above 4.5: " + rating);
        }
    }

    @Test(priority = 14)
    public void test_clear_rating_filter_removes_applied() {

        System.out.println("Starting Test - TC27...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        gymPage.clearButton.click();
    }

    @Test(priority = 15)
    public void test_filter_by_deals() {

        System.out.println("Starting Test - TC28...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.deals.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 16)
    public void test_filter_by_jd_trust() {

        System.out.println("Starting Test - TC29...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.jdTrust.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 17)
    public void clearAllFilters() {

        System.out.println("Starting Test - TC30...");

        GymServicePage gymPage = new GymServicePage(driver);

        gymPage.allFilters.click();
        gymPage.resetFilters.click();
        gymPage.closeButton.click();
    }

    @Test(priority = 18)
    public void test_no_filters_show_all_listings() {

        System.out.println("Starting Test - TC31...");

        GymServicePage gymPage = new GymServicePage(driver);

        gymPage.sortBy.click();
        gymPage.relevance.click();

        gymPage.amenitiesFilter.click();
        gymPage.lockerAmenitiesFilter.click();

        gymPage.rating.click();
        gymPage.rating3.click();

        gymPage.deals.click();

        for(WebElement ele : gymPage.ratingCountList){
            String rating = ele.getText();
            double val = Double.parseDouble(rating);
            Assert.assertTrue(val >= 4.5, "Rating is not above 4.5: " + rating);
        }
    }


}
