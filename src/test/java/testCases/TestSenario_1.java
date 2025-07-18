package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.HomePage;

public class TestSenario_1 extends BaseTest{
	

	
	//Login and sign up test cases
	

	@Test(priority=1, groups = {"smoke"} , description = "To check if the Website \"justdial.com\" is opening")
	public void verify_justdial_website_access() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.closePopUp();
		logger.info("PopUp closed");
		String title1 = driver.getTitle();
		
		Assert.assertEquals(title1, "Find Businesses Near You on Local Search Engine - Justdial");
		logger.info("Home page is validated");
		logger.info("Test case 1 passed");
	}
	
	
	@Test(priority=2, groups = {"sanity", "smoke"}, description = "To check whether the login page is open after clicking on loginandSignup button")
	public void verify_login_page_navigation() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.loginAndSignup.click();
		logger.info("login page is opened");
		String loginIntro = hp.getLoginText();
		hp.skilLoginPage();
		logger.info("login page skiped");

		Assert.assertEquals(loginIntro, "Login for a seamless experience");
		logger.info("login page is validated");
		
		logger.info("Test case 2 passed");
	}
	
	
	@Test(priority=3, groups = {"sanity", "smoke"}, description = "To check whether the location box,search box,search button  are visible on home page or not.")
	public void verify_homepage_elements_visibility() throws IOException {
		HomePage hp = new HomePage(driver);
		String loc_field = driver.findElement(hp.locationInput).getAttribute("aria-controls");
		String input_field = hp.serviceInput.getAttribute("aria-label");
		
		if(loc_field.equals("locbox") && input_field.equals("Search")) {
			Assert.assertTrue(true);
			logger.info("location and search field is validated");
		}else {
			Assert.assertFalse(false);
			logger.error("Location and search field test case failed");
		}
	}
}
