package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.CarWashServicePage;
import utils.ActionsUtilis;
import utils.Screenshots;

public class TestSenario_2 extends BaseTest{

	//Car washing test cases
		
	
	@Test(priority = 1, groups={"Regression"}, dataProvider = "getDataForCarWashing", description = "To verify that  after entring \"Car washing service\" and click on search icon,car wash page appear or not.")
	public void search_car_washing_service_page_displayed(String location, String searchText) {
				
		CarWashServicePage csp = new CarWashServicePage(driver);
		try {
			csp.searchCarWashService(location, searchText);
			logger.info("Location and car wash service provided");
			String actualTitle2 = csp.getTitle();
			logger.info("Car wash service title captured");
			Screenshots.screenShot("CarWashingPage", driver);
			logger.info("Car wash service screenshot captured");
			if(actualTitle2.contains("Top Car Washing Services")) {
				Assert.assertTrue(true);
				logger.info("Car wash service title validated");
			}else {
				Assert.assertTrue(false);
				logger.info("Car wash service title validation failed");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=2, groups={"Regression"}, description = "To verify that after selecting the location near by the user,then result are according to location or not")
	public void verify_results_by_location() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		boolean isSame = csp.check_location("Chennai");
		Assert.assertTrue(isSame);
		logger.info("The location as Chennai is validated");
	}
	
	
	@Test(priority=3, groups={"Regression"}, description = "To verify that each search result contains service name, contact number, and other details")
	public void verify_search_result_details() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		ActionsUtilis.scrollByAmount(driver, 0,100);
		logger.info("Car wash page scrolled");
		Assert.assertTrue(csp.checkForAllFielsDataIsAvailable());
		logger.info("service page is not empty");
		logger.info("fields are avaiable in result");
	}
	

	@Test(priority=4, groups={"Regression"}, description = "To verify that after Applying Filter for rating then all displayed services have rating 4+")
	public void verify_rating_filter_applied() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		try {
			csp.getCarWashingServiceandPhone();
			logger.info("Car washing service names, phone no, rating, votes are stored in lists");
			Assert.assertTrue(csp.isSortedOrNot());
			logger.info("Sorted is validated");
			Screenshots.screenShot("ratingFilter", driver);
			logger.info("Screenshot of rating captured");

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=5, groups={"Regression"}, description = "To verify whether 'BEST DEAL' filter in search results page is working or not.")
	public void verify_best_deal_filter() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		try {
			csp.deals.click();
	        logger.info("clicked on deals");
	        Assert.assertTrue(csp.assertDeals.isDisplayed(),"Deals filter should be active");
	        logger.info("Test case validated");
	        
		}catch(Exception e) {
			logger.info("Test case verify_best_deal_filter failes");
		}finally {
			driver.findElement(By.xpath("//*[@id=\"__next\"]/section/header/div/div[1]/div/a/img")).click();
			logger.info("redirected to Homepage");
		}
	}

	
	
}
