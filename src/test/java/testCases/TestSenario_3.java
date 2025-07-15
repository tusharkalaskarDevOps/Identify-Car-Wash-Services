package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjectModels.FreeListingPage;
import pageObjectModels.HomePage;

public class TestSenario_3 extends BaseTest{
	

	//Test case for validating free listing button
	
	@Test(priority=1)
	public void freeListing_Button() {
		HomePage homepage = new HomePage(driver);
		try {
			homepage.closePopUp();
			String ActualText = homepage.getFreeListingButtonText();
			String ExpectedText = "Free Listing";
			Assert.assertEquals(ActualText,ExpectedText);
			System.out.println("test free listing 1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//Test case for validating the free listing page
	
	@Test(priority=2)
	public void freeListing_Button_Click() {
		HomePage homepage = new HomePage(driver);
		homepage.freeListing.click();
		String ActualText = driver.getTitle();
		
		Assert.assertEquals(ActualText,"Unlock Business Growth | Get Listed for FREE on Justdial");
		System.out.println("test free listing 2");
	}
	
	//Test case for wrong number validation
	
	@Test(priority=3)  
	public void freeListing_Mobile_TextField_invalid() throws IOException, InterruptedException {
		
		System.out.println("start the method");
		
		FreeListingPage freelistingpage = new FreeListingPage(driver);
		System.out.println("start the method 2");
		freelistingpage.enterWrongPhn("123467890");
		System.out.println("start the method 3");
		try{
			System.out.println("start the method 4");
			String errormessage = freelistingpage.captureErrorMessage();
			System.out.println("start the method 5"); 
			System.out.println("error msg:"+errormessage);
			System.out.println("start the method 6");
			String Actual_message = errormessage;
			String Expected_messsage = "Please Enter a Valid Mobile Number"; 
			System.out.println("start the method 7");
			
			
			Assert.assertEquals(Actual_message,Expected_messsage);
			System.out.println("test free listing 3");
			// call method to insert msg to excel file
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
		
		freelistingpage.crossOTP();
		freelistingpage.logo.click();
		if(actual_message.contains(expected_messsage)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		System.out.println("test free listing 4");
	}
	
	
	
	
	
	

}
