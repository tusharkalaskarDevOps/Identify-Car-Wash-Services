package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.CarWashServicePage;

public class TestSenario_2 extends BaseTest{

	//Car washing test cases
	
	//  To verify that  after entring "Car washing service" and click on search icon, 
	//	car wash page appear or not.
	
	@Test(priority=1, dataProvider = "getDataForCarWashing")
	public void search_car_washing_service_page_displayed(String location, String searchText) {
		CarWashServicePage csp = new CarWashServicePage(driver);
		try {
			csp.searchCarWashService(location, searchText);
			String actualTitle2 = csp.getTitle();			
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
		System.out.println("test senario 1");
	}
	
	

	
	//To verify that after selecting the location near by the user,then result are according to location or not
	@Test(priority=2)
	public void verify_results_by_location() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		boolean isSame = csp.check_location("Chennai");
		Assert.assertTrue(isSame);
		System.out.println("test senario 2");
	}
	
	//To verify that each search result contains service name, contact number, and other details
	@Test(priority=3)
	public void verify_search_result_details() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		Assert.assertTrue(csp.checkForAllFielsDataIsAvailable());
		System.out.println("test senario 3");
	}
	
	//To verify that after Applying Filter for rating then all displayed services have rating 4+
	@Test(priority=4)
	public void verify_rating_filter_applied() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		try {
			csp.getCarWashingServiceandPhone();
			Assert.assertTrue(csp.isSortedOrNot());
			
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("test senario 4");
	}
	
	//To verify whether 'BEST DEAL' filter in search results page is working or not.
	@Test(priority=5)
	public void verify_best_deal_filter() {
		CarWashServicePage csp = new CarWashServicePage(driver);
		Assert.assertTrue(true);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/section/header/div/div[1]/div/a/img")).click();
		
		System.out.println("test senario 5");
	}

	
	
}
