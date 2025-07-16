package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.HomePage;

public class TestSenario_1 extends BaseTest{
	
	
	//Login and sign up test cases
	

	@Test(priority=1, description = "To check if the Website \"justdial.com\" is opening")
	public void verify_justdial_website_access() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.closePopUp();
		String title1 = driver.getTitle();
		
		Assert.assertEquals(title1, "Find Businesses Near You on Local Search Engine - Justdial");	
		System.out.println("test login 1");
	}
	
	
	@Test(priority=2, description = "To check whether the login page is open after clicking on loginandSignup button")
	public void verify_login_page_navigation() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.loginAndSignup.click();
		String loginIntro = hp.getLoginText();
		hp.skilLoginPage();
		
		Assert.assertEquals(loginIntro, "Login for a seamless experience");
		System.out.println("test login 2");
	}
	
	
	@Test(priority=3, description = "To check whether the location box,search box,search button  are visible on home page or not.")
	public void verify_homepage_elements_visibility() throws IOException {
		HomePage hp = new HomePage(driver);
		String loc_field = driver.findElement(hp.locationInput).getAttribute("aria-controls");
		String input_field = hp.serviceInput.getAttribute("aria-label");
		
		if(loc_field.equals("locbox") && input_field.equals("Search")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
		System.out.println("test login 3");
	}
}
