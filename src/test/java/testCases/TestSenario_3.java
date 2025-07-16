package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.FreeListingPage;
import pageObjectModels.HomePage;
import utils.ExcelUtils;
import utils.Screenshots;

public class TestSenario_3 extends BaseTest{
	

	@Test(priority=1, description = "Test case for validating free listing button")
	public void freeListing_Button() throws IOException {
		HomePage homepage = new HomePage(driver);
		String ActualText = homepage.getFreeListingButtonText();
		String ExpectedText = "Free Listing";
		
		Assert.assertEquals(ActualText,ExpectedText);
	}
	
	
	@Test(priority=2, description = "Test case for validating the free listing page")
	public void freeListing_Button_Click() {
		HomePage homepage = new HomePage(driver);
		homepage.freeListing.click();
		String ActualText = driver.getTitle();
		
		Assert.assertEquals(ActualText,"Unlock Business Growth | Get Listed for FREE on Justdial");
	}
	
	
	@Test(priority=3, description = "Test case for wrong number validation")  
	public void freeListing_Mobile_TextField_invalid() throws IOException, InterruptedException {
				
		FreeListingPage freelistingpage = new FreeListingPage(driver);
		freelistingpage.enterWrongPhn("123464645");
		try{
			String errormessage = freelistingpage.captureErrorMessage();
			String Actual_message = errormessage;
			String Expected_messsage = "Please Enter a Valid Mobile Number"; 
			ExcelUtils.write_error_message_ofFreeListing(errormessage);
			String path=Screenshots.screenShot("errorMsg", driver);
			Assert.assertEquals(Actual_message,Expected_messsage);
		}
		catch(IOException e) {
			System.out.println("Exception is found");
		}	
	}
	
	
	@Test(priority=4, description = "Test case for correct number validations")
	public void freeListing_Mobile_TextField_valid() throws InterruptedException, IOException {
		FreeListingPage freelistingpage = new FreeListingPage(driver);
		driver.navigate().refresh();
		freelistingpage.enterCorrectPhn("8342310004");
		String otpMsg = freelistingpage.otpFinder.getText();
		String actual_message = otpMsg;
		String expected_messsage = "Enter the code sent to ";
		String path=Screenshots.screenShot("otpPage", driver);
		freelistingpage.crossOTP();
		freelistingpage.logo.click();
		if(actual_message.contains(expected_messsage)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
}
