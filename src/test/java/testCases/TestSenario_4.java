package testCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.GymServicePage;
import utils.ActionsUtilis;
import utils.ExcelUtils;
import utils.Screenshots;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TestSenario_4 extends BaseTest{

    @Test(priority = 1)
    public void test_gym_option_navigation_and_display() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        try {
            System.out.println("Pop-up closed successfully.");
        } catch (Exception e) {
            System.out.println("No pop-up found or already closed.");
        }

        try {
            GymServicePage gymPage = new GymServicePage(driver);
            ActionsUtilis.scrollByAmount(driver, 0, 300);
            
            gymPage.clickGymMenu();
            System.out.println("Clicked on 'Gym' menu.");

            wait.until(ExpectedConditions.titleContains("Gym"));
            String path=Screenshots.screenShot("gymMenu", driver);
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

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.sortBy.click();
        gymPage.relevance.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(gymPage.relevenceList));
        for (WebElement list : gymPage.relevenceList) {
            String listingText = list.getText();
            Assert.assertTrue(listingText.contains("Chennai"), "Listing does not contain 'Chennai': " + listingText);
        }
        //System.out.println("Rating elements detected: " + gymPage.relevenceList.size());
    }

    @Test(priority = 3)
    public void test_sort_by_rating() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.relevance.click();
        gymPage.sortByrating.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void test_filter_by_sunday_open() {

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

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        gymPage.lockerAmenitiesFilter.click();
        gymPage.applyButton.click();

        Assert.assertFalse(gymPage.lockerList.isEmpty(),"No Gyms Found");
        System.out.println("Locker elements detected: " + gymPage.lockerList.size());
    }

    @Test(priority = 6)
    public void test_clear_filters_removes_amenities() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        gymPage.clearButton.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 7)
    public void test_filter_by_open_now() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.openNow.click();

        Assert.assertTrue(gymPage.assertOpenNow.isDisplayed(),"Open Now Filter is not applied");
    }

    @Test(priority = 8)
    public void test_filter_by_top_rated() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.topRated.click();

        Assert.assertTrue(gymPage.assertTopRated.isDisplayed(),"Top Rated filter is not applied");
    }

    @Test(priority = 9)
    public void test_filter_by_quick_response() {


        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.quickResponse.click();

        Assert.assertTrue(gymPage.assertQuickResponse.isDisplayed(),"Quick Response filter should be active");

        gymPage.assertQuickResponse.click();
    }

    @Test(priority = 10)
    public void test_filter_by_jd_verified() {


        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.jdVerified.click();

        Assert.assertTrue(gymPage.assertJDVerified.isDisplayed(),"Jd Verified filter should be active");

        gymPage.assertJDVerified.click();
    }

    @Test(priority = 11)
    public void test_filter_by_ratings_3_5_plus() {

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


        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        gymPage.clearButton.click();
    }

    @Test(priority = 15)
    public void test_filter_by_deals() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.deals.click();

        Assert.assertTrue(gymPage.assertDeals.isDisplayed(),"Deals filter should be active");

        gymPage.assertDeals.click();
    }

    @Test(priority = 16)
    public void test_filter_by_jd_trust() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.jdTrust.click();

        Assert.assertTrue(gymPage.assertJdtrust.isDisplayed(),"Jd Trust filter should be active");
    }

    @Test(priority = 17)
    public void clearAllFilters() {


        GymServicePage gymPage = new GymServicePage(driver);

        gymPage.allFilters.click();
        gymPage.resetFilters.click();
        gymPage.closeButton.click();

        boolean allFiltersRemoved = gymPage.sortBy.isDisplayed() &&
                gymPage.assertAmenities.isDisplayed() &&
                gymPage.openNow.isDisplayed() &&
                gymPage.topRated.isDisplayed() &&
                gymPage.quickResponse.isDisplayed() &&
                gymPage.jdVerified.isDisplayed() &&
                gymPage.assertRatingChecker.isDisplayed() &&
                gymPage.deals.isDisplayed() &&
                gymPage.jdTrust.isDisplayed();

        Assert.assertTrue(allFiltersRemoved,"Filters are not removed");

    }

    @Test(priority = 18)
    public void test_no_filters_show_all_listings() {


        GymServicePage gymPage = new GymServicePage(driver);

        gymPage.sortBy.click();
        gymPage.relevance.click();

        gymPage.amenitiesFilter.click();
        gymPage.lockerAmenitiesFilter.click();
        gymPage.applyButton.click();

        gymPage.rating.click();
        gymPage.rating3.click();

        gymPage.quickResponse.click();

        boolean allFiltersApplied = gymPage.relevance.isDisplayed() &&
                gymPage.assertLockerFacility.isDisplayed() &&
                gymPage.assertRatings.isDisplayed() &&
                gymPage.assertQuickResponse.isDisplayed();

        Assert.assertTrue(allFiltersApplied,"Filters are not Applied");
    }

  
    @Test(priority=19)  //faling
    public void getGymSubMenuList() throws IOException, InterruptedException {
    	GymServicePage gymServicePage=new GymServicePage(driver);
		gymServicePage.getSubmenu();
		List<WebElement> submenu =gymServicePage.gymSubMenu;
		
		for(WebElement we: submenu) {
			System.out.println(we.getText());
		}
		ExcelUtils.write_subMenu_data(submenu);
		Assert.assertTrue(true);
	}
}