package testCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.GymServicePage;
import pageObjectModels.HomePage;

public class TestSenario_4 extends BaseTest{

	@Test(priority = 1)
    public void TC14() throws Exception {

        System.out.println("Starting Test - TC14...");
        HomePage homePage = new HomePage(driver);
//        homePage.closePopUp(); // Call the closePopUp method
//        System.out.println("PopUp closed successfully.");
        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.clickGymMenu(); // Navigate to the Gym option
        System.out.println("Gym Page Opens with Listings...");
        
		homePage.locationSearch("Chennai"); //Giving Location Name in Search Input

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Top Gyms in Sirucheri, Chennai - Best Fitness Centers near me - Justdial"));
        String title1 =  driver.getTitle();
        Assert.assertEquals(title1,"Top Gyms in Sirucheri, Chennai - Best Fitness Centers near me - Justdial");
    }

    @Test(priority = 2)
    public void TC15() {
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
    public void TC16() {
        System.out.println("Starting Test - TC16...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.relevance.click();
        gymPage.sortByrating.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void TC17() {
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
    public void TC18() {
        System.out.println("Starting Test - TC18...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        gymPage.lockerAmenitiesFilter.click();
        gymPage.applyButton.click();

        Assert.assertFalse(gymPage.lockerList.isEmpty(),"No Gyms Found");
        System.out.println("Locker elements detected: " + gymPage.lockerList.size());
    }

    @Test(priority = 6)
    public void TC19() {
        System.out.println("Starting Test - TC19...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.amenitiesFilter.click();
        gymPage.clearButton.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 7)
    public void TC20() {
        System.out.println("Starting Test - TC20...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.openNow.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 8)
    public void TC21() {
        System.out.println("Starting Test - TC21...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.topRated.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 9)
    public void TC22() {
        System.out.println("Starting Test - TC22...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.quickResponse.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 7)
    public void TC23() {
        System.out.println("Starting Test - TC23...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.jdVerified.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 8)
    public void TC24() {
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

    @Test(priority = 9)
    public void TC25() {
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

    @Test(priority = 10)
    public void TC26() {
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

    @Test(priority = 11)
    public void TC27() {
        System.out.println("Starting Test - TC27...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.deals.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 12)
    public void TC28() {
        System.out.println("Starting Test - TC28...");

        GymServicePage gymPage = new GymServicePage(driver);
        gymPage.jdTrust.click();

        Assert.assertTrue(true);
    }

    @Test(priority = 13)
    public void clearAllFilters() {

    }
		
}
 
