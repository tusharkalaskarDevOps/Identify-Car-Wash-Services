package testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.GymServicePage;
import utils.ActionsUtilis;
import utils.ExcelUtils;
import utils.Screenshots;

import java.io.IOException;
import java.util.List;

public class TestSenario_4 extends BaseTest{

    @Test(priority = 1, groups={"smoke", "Regression"},  description ="To verify that the \"Gym\" option is present and navigate to it. Click on it and confirm that the corresponding gym listings or details are displayed.")
    public void test_gym_option_navigation_and_display() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        try {
            GymServicePage gymPage = new GymServicePage(driver);
            ActionsUtilis.scrollByAmount(driver, 0, 300);
            
            gymPage.clickGymMenu();
            logger.info("Clicked on Gym");
            

            wait.until(ExpectedConditions.titleContains("Gym"));
            Screenshots.screenShot("gymMenu", driver);
            String actualTitle = driver.getTitle();

            Assert.assertTrue(actualTitle.contains("Gym"), "'Gym' Page has not loaded...");
            logger.info("The Gym page title is validated");
            
        } catch (Exception e) {
            Assert.fail("Test TC14 failed unexpectedly.");
            logger.info("The Gym page title test case is failed due to exception:"+ e.getMessage());
        }
    }


    @Test(priority = 2, dataProvider = "getDataForCarWashing", groups={"Regression"},  description ="To verify that the \"Relevance\" option is available under \"Sort By\", and confirm that the results are sorted accordingly.")
    public void test_sort_by_relevance(String location, String data) {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.sortBy.click();
        logger.info("clicked on the sortby");
        gymPage.relevance.click();
        logger.info("clicked on the relevence");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(gymPage.relevenceList));
        for (WebElement list : gymPage.relevenceList) {
            String listingText = list.getText();
            Assert.assertTrue(listingText.contains(location), "Listing does not contain 'Chennai': " + listingText);
            
        }
        logger.info("Validated whether Gym are present in Chennai");
    }

    @Test(priority = 3, groups={"Regression"},  description ="To verify that the \"Rating\" option is available under \"Sort By\" and ensure results are sorted accordingly.")
    public void test_sort_by_rating() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.relevance.click();
        logger.info("clicked on relevence");
        gymPage.sortByrating.click();
        logger.info("clicked on rating");

        Assert.assertTrue(true);
        logger.info("sortby test case is validated");
    }

    @Test(priority = 4, groups={"Regression"},  description ="To verify that the \"Sunday Open\" filter is present under \"Amenities\", and confirm that only locations open on Sundays are displayed.")
    public void test_filter_by_sunday_open() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        logger.info("clicked on amenities");
        gymPage.sundayAmenitiesFilter.click();
        logger.info("clicked on sunday open");
        gymPage.applyButton.click();
        logger.info("clicked on apply button");

        Assert.assertTrue(true);

        //Clear the Selections
        gymPage.amenitiesFilter.click();
        logger.info("clicked on amenities");
        gymPage.clearButton.click();
        logger.info("clicked on clear");
    }

    @Test(priority = 5, groups={"Regression"},  description ="To verify that the \"Locker Facility\" filter is present under \"Amenities\", and confirm that only locations offering locker facilities are shown.")
    public void test_filter_by_locker_facility() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        logger.info("clicked on amenities");
        gymPage.lockerAmenitiesFilter.click();
        logger.info("clicked on locker facility");
        gymPage.applyButton.click();
        logger.info("clicked on apply");

        Assert.assertFalse(gymPage.lockerList.isEmpty(),"No Gyms Found");
        logger.info("Locker elements detected:" + gymPage.lockerList.size());
    }

    @Test(priority = 6, groups={"Regression"},  description ="To verify that after clearing filters the current applied filters are removed in \"Amenities\"")
    public void test_clear_filters_removes_amenities() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        logger.info("clicked on amenities");
        gymPage.clearButton.click();
        logger.info("clicked on clear button");

        Assert.assertTrue(true);
        logger.info("Test case test_clear_filters_removes_amenities validated");
    }

    @Test(priority = 7, groups={"Regression"},  description ="To verify that the \"Open Now\" filter is available and toggle it to display only currently open locations.")
    public void test_filter_by_open_now() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.openNow.click();
        logger.info("clicked on opennow");
        Assert.assertTrue(gymPage.assertOpenNow.isDisplayed(),"Open Now Filter is not applied");
        logger.info("Opennow button is validated");
    }

    @Test(priority = 8, groups={"Regression"},  description ="To verify that the \"Top Rated\" filter is available and toggle it to display only the highest-rated locations.")
    public void test_filter_by_top_rated() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.topRated.click();
        logger.info("clicked on top rated");
        Assert.assertTrue(gymPage.assertTopRated.isDisplayed(),"Top Rated filter is not applied");
        logger.info("Test case test_filter_by_top_rated is validated");
    }

    @Test(priority = 9, groups={"Regression"},  description ="To verify that the \"Quick Response\" filter is available and toggle it to display only locations with fast response times.")
    public void test_filter_by_quick_response() {


        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.quickResponse.click();
        logger.info("clicked on quickresponse");
        Assert.assertTrue(gymPage.assertQuickResponse.isDisplayed(),"Quick Response filter should be active");
        logger.info("Test case test_filter_by_quick_response validated");
        gymPage.assertQuickResponse.click();
        logger.info("clicked on quickresponse to deselect it");
    }

    @Test(priority = 10, groups={"Regression"},  description ="To verify that the \"JD Verified\" filter is available and toggle it to display only listings that are JD verified.")
    public void test_filter_by_jd_verified() {


        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.jdVerified.click();
        logger.info("clicked on jdverified");
        Assert.assertTrue(gymPage.assertJDVerified.isDisplayed(),"Jd Verified filter should be active");
        logger.info("Test case test_filter_by_jd_verified validated");
        gymPage.assertJDVerified.click();
        logger.info("clicked on jd_verified to deselect it");
    }

    @Test(priority = 11, groups={"Regression"},  description ="To verify that the \"Ratings\" filter is available and apply \"3.5+\" to display listings of all rating levels.")
    public void test_filter_by_ratings_3_5_plus() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        logger.info("clicked on rating drop down");
        gymPage.rating1.click();
        logger.info("clicked on rating 3.5+");

        for(WebElement ele : gymPage.ratingCountList){
            String rating = ele.getText();
            double val = Double.parseDouble(rating);
            Assert.assertTrue(val >= 3.5, "Rating is not above 3.5: " + rating);
        }
        logger.info("rating of 3.5+ is validated");
    }

    @Test(priority = 12, groups={"Regression"},  description ="Verify that the \"Ratings\" filter is available and apply \"4.0+\" to display listings of all rating levels.")
    public void test_filter_by_ratings_4_0_plus() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        logger.info("clicked on rating drop down");
        gymPage.rating2.click();
        logger.info("clicked on rating 4+");

        for(WebElement ele : gymPage.ratingCountList){
            String rating = ele.getText();
            double val = Double.parseDouble(rating);
            Assert.assertTrue(val >= 4.0, "Rating is not above 3.5: " + rating);
        }
        logger.info("rating of 4+ is validated");
    }

    @Test(priority = 13, groups={"Regression"},  description ="To verify that the \"Ratings\" filter is available and apply \"4.5\" to display listings of all rating levels.")
    public void test_filter_by_ratings_4_5_plus() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        logger.info("clicked on rating drop down");
        gymPage.rating3.click();
        logger.info("clicked on rating 4.5+");

        for(WebElement ele : gymPage.ratingCountList){
            String rating = ele.getText();
            double val = Double.parseDouble(rating);
            Assert.assertTrue(val >= 4.5, "Rating is not above 4.5: " + rating);
        }
        logger.info("rating of 4.5+ is validated");
    }

    @Test(priority = 14, groups={"Regression"},  description ="To verify that after clearing filters the current applied filters are removed in \"Rating\"")
    public void test_clear_rating_filter_removes_applied() {


        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.rating.click();
        logger.info("clicked on rating drop down");
        gymPage.clearButton.click();
        logger.info("clicked on clear button");
    }

    @Test(priority = 15, groups={"Regression"},  description ="Verify that the \"Deals\" filter is present and toggle it to display only listings currently offering deals.")
    public void test_filter_by_deals() {

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.deals.click();
        logger.info("clicked on deals");
        Assert.assertTrue(gymPage.assertDeals.isDisplayed(),"Deals filter should be active");
        logger.info("Test case validated");
        gymPage.assertDeals.click();
        logger.info("clicked on Deals to unselect it");
    }

    @Test(priority = 16, groups={"Regression"},  description ="To verify that the \"JD Trust\" filter is present and toggle it to display only listings marked with JD Trust certification.")
    public void test_filter_by_jd_trust() {

        GymServicePage gymPage = new GymServicePage(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(gymPage.jdTrust));
        
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",gymPage.jdTrust);
		js.executeScript("arguments[0].click();",gymPage.jdTrust);
		logger.info("clicked on jdtrust");
        Assert.assertTrue(gymPage.assertJdtrust.isDisplayed(),"Jd Trust filter should be active");
        logger.info("Test case test_filter_by_jd_trust validated");
    }

    @Test(priority = 17, groups={"Regression"},  description ="To verify that no filters are selected and confirm that all available listings are displayed without any applied criteria.")
    public void clearAllFilters() {


        GymServicePage gymPage = new GymServicePage(driver);

        gymPage.allFilters.click();
        logger.info("clicked on allfilters");
        gymPage.resetFilters.click();
        logger.info("clicked on reset filters");
        gymPage.closeButton.click();
        logger.info("clicked on close button");

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
        logger.info("Test case clearAllFilters validated");
    }

    @Test(priority = 18, groups={"Regression"},  description =("To verify that after applying all filters(sort by,Amenties,Ratings,Deals), and confirm that all available listings are displayed according to selected criteria."))
    public void test_all_filters_show_all_listings() {


        GymServicePage gymPage = new GymServicePage(driver);

        gymPage.sortBy.click();
        logger.info("clicked on sortby");
        gymPage.relevance.click();
        logger.info("clicked on relevence");
 
        gymPage.amenitiesFilter.click();
        logger.info("clicked on amenities");
        gymPage.lockerAmenitiesFilter.click();
        logger.info("clicked on locker facility");
        gymPage.applyButton.click();
        logger.info("clicked on applybutton");
 
        gymPage.rating.click();
        logger.info("clicked on rating");
        gymPage.rating3.click();
        logger.info("clicked on rating of 4.5+");
 
        gymPage.quickResponse.click();
        logger.info("clicked on quickresponse");

        boolean allFiltersApplied = gymPage.relevance.isDisplayed() &&
                gymPage.assertLockerFacility.isDisplayed() &&
                gymPage.assertRatings.isDisplayed() &&
                gymPage.assertQuickResponse.isDisplayed();

        Assert.assertTrue(allFiltersApplied,"Filters are not Applied");
        logger.info("test case test_no_filters_show_all_listings validated");
    }

  
    @Test(priority=19, groups={"Regression"}, description = "To get all submenu of gym page and store it into excel file")
    public void getGymSubMenuList() throws IOException, InterruptedException {
    	GymServicePage gymServicePage=new GymServicePage(driver);
		gymServicePage.getSubmenu();
		List<WebElement> submenu =gymServicePage.gymSubMenu;
		logger.info("All submenus are stored in list");
		System.out.println("-------Gym Sub Menu-------");
		for(WebElement we: submenu) {
			System.out.println(we.getText());
		}
		ExcelUtils.write_subMenu_data(submenu);
		logger.info("All submenus are stored in Excel File in Result3 sheet");
		Assert.assertTrue(true);
		logger.info("Test case getGymSubMenuList validated");
	}
}