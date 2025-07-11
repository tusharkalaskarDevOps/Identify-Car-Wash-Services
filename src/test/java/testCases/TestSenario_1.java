package testCases;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseTest;
import pageObjectModels.HomePage;

public class TestSenario_1 extends BaseTest{
	
	//Login and sign up test cases
	
	//To check if the Website "justdial.com" is opening
	@Test(priority=1)
	public void TC1() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.closePopUp();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Find Businesses Near You on Local Search Engine - Justdial");	
	}
	
	
	//To check whether the login page is open after clicking on loginandSignup button
	@Test(priority=2)
	public void TC2() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.loginAndSignup.click();
		String loginIntro = hp.getLoginText();
		hp.skilLoginPage();
		Assert.assertEquals(loginIntro, "Login for a seamless experience");
	}
	
	
	//To check whether the location box,search box,search button  are visible on home page or not.
	@Test(priority=3)
	public void TC3() throws IOException {
		HomePage hp = new HomePage(driver);
		String loc_field = hp.locationInput.getAttribute("aria-controls");
		String input_field = hp.serviceInput.getAttribute("aria-label");
		if(loc_field.equals("locbox") && input_field.equals("Search")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
	}
	
}
