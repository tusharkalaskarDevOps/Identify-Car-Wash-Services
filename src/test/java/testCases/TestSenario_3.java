package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.FreeListingPage;
import pageObjectModels.HomePage;

public class TestSenario_3 extends BaseTest{

	//errormessage declaration
	public String errormessage;
	

	//Test case for validating free listing button
	
	@Test(priority=1)
	public void freeListing_Button() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.closePopUp();
		String ActualText = homepage.getFreeListingButtonText();
		String ExpectedText = "Free Listing";
		
		Assert.assertEquals(ActualText,ExpectedText);
		
	}
	
	//Test case for validating the free listing page
	
	@Test(priority=2)
	public void freeListing_Button_Click() {
		HomePage homepage = new HomePage(driver);
		homepage.freeListing.click();
		String ActualText = driver.getTitle();
		Assert.assertEquals(ActualText,"Unlock Business Growth | Get Listed for FREE on Justdial");
		
	}
	
	//Test case for wrong number validation
	
	@Test(priority=3)
	public void freeListing_Mobile_TextField_invalid() throws IOException, InterruptedException {
		FreeListingPage freelistingpage = new FreeListingPage(driver);
		freelistingpage.enterWrongPhn("123467890");
		try{
			errormessage = freelistingpage.captureErrorMessage();
			String Actual_message = errormessage;
			String Expected_messsage = "Please Enter a Valid Mobile Number";
			
			Assert.assertEquals(Actual_message,Expected_messsage);
		
			
		}
		catch(IOException e) {
			System.out.println("Exception is found");
		}
	}
	
	
	//Test case for correct number validations
	
	@Test(priority=4)
	public void freeListing_Mobile_TextField_valid() throws InterruptedException, IOException {
		FreeListingPage freelistingpage = new FreeListingPage(driver);
		driver.navigate().refresh();
		
		freelistingpage.enterCorrectPhn("8374592634");
		String otpMsg = freelistingpage.otpFinder.getText();
		String actual_message = otpMsg;
		String expected_messsage = "Enter the code sent to ";
		
		if(actual_message.contains(expected_messsage)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	

}
