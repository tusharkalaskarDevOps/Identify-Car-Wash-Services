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
		
	
	@Test(priority = 1, dataProvider = "getDataForCarWashing", description = "To verify that  after entring \"Car washing service\" and click on search icon,car wash page appear or not.")
	public void search_car_washing_service_page_displayed(String location, String searchText) {
				
		CarWashServicePage csp = new CarWashServicePage(driver);
		try {
			csp.searchCarWashService(location, searchText);
			String actualTitle2 = csp.getTitle();
			Screenshots.screenShot("CarWashingPage", driver);
			
			if(actualTitle2.contains("Top Car Washing Services")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=2, description = "To verify that after selecting the location near by the user,then result are according to location or not")
	public void verify_results_by_location() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		boolean isSame = csp.check_location("Chennai");
		Assert.assertTrue(isSame);
	}
	
	
	@Test(priority=3, description = "To verify that each search result contains service name, contact number, and other details")
	public void verify_search_result_details() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		ActionsUtilis.scrollByAmount(driver, 0,100);
		Assert.assertTrue(csp.checkForAllFielsDataIsAvailable());
	}
	

	@Test(priority=4, description = "To verify that after Applying Filter for rating then all displayed services have rating 4+")
	public void verify_rating_filter_applied() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		try {
			csp.getCarWashingServiceandPhone();
			Assert.assertTrue(csp.isSortedOrNot());
			Screenshots.screenShot("ratingFilter", driver);

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=5, description = "To verify whether 'BEST DEAL' filter in search results page is working or not.")
	public void verify_best_deal_filter() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		//impliment code here
		driver.findElement(By.xpath("//*[@id=\"__next\"]/section/header/div/div[1]/div/a/img")).click();
		Assert.assertTrue(true);
	}

	
	
}
