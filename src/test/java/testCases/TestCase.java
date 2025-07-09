package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.CarWashServicePage;
import pageObjectModels.FreeListingPage;
import pageObjectModels.GymServicePage;
import pageObjectModels.HomePage;

public class TestCase extends BaseTest{
	
	@Test(priority=1)
	public void closeWelcomePopUp() throws IOException, InterruptedException {
		System.out.println("Starting Running Test Cases");
		HomePage homePage=new HomePage(driver);
		homePage.closePopUp(); //Closing the Pop Up
		System.out.println("Closing popup");
	}
	
	@Test(priority=3, dataProvider = "getDataForCarWashing")
	public void searchCarWashService(String location, String serach_text) throws IOException, InterruptedException {
		HomePage homePage=new HomePage(driver);
		homePage.locationSearch(location); //Giving Location Name in Search Input
		System.out.println("Giving location input");
		homePage.serviceSearch(serach_text); //Giving Service Name in Search Input
		System.out.println("Giving service input");
	}
	
	@Test(priority=4)
	public void getCarWashingServiceandPhoneZZZZ() throws InterruptedException, IOException {
		CarWashServicePage carWashServicePage=new CarWashServicePage(driver);
		carWashServicePage.getCarWashingServiceandPhone();//Storing and Printing Car wash Services List
		System.out.println("Getting top 5 car wash services");	
	}
	
	@Test(priority=5, dataProvider = "getDataForFreeListing")
	public void freeListingValidation(String mobileNumber) throws IOException, InterruptedException {
		FreeListingPage freeListPage=new FreeListingPage(driver);
		HomePage homePage=new HomePage(driver);
		homePage.openFreeListing();//Opening FreeListing Page
		System.out.println("Freelisting page is opened");
		freeListPage.enterWrongPhn(mobileNumber); //Entering Wrong Phone Number
		System.out.println("Enter the wrong Number");
		freeListPage.captureErrorMessage(); //Printing Error Message
		System.out.println("Capturing error message");
		Assert.assertEquals(freeListPage.errorMessage.getText(), "Please Enter a Valid Mobile Number");
	}
	
	@Test(priority=6)
	public void getGymSubMenuList() throws IOException, InterruptedException {
		GymServicePage gymServicePage=new GymServicePage(driver);
		gymServicePage.openApp(); //Navigating to Home Page
		System.out.println("Opening home page");
//		Assert.assertEquals(gymServicePage.gymIcon.getText(), "Gym");
		gymServicePage.clickGymMenu(); //Clicking Gym Icon
		System.out.println("Clicking Gym Menu Icon");
		gymServicePage.getSubmenu();
		List<WebElement> submenu =gymServicePage.gymSubMenu;
		
		for(WebElement we: submenu) {
			System.out.println(we.getText());
		}
		
		System.out.println("Getting the submenu of gym");
				
	}
	
}
