package pageObjectModels;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeListingPage extends BasePage{
	
	//Constructor
	public FreeListingPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	//Locating PhoneNumber textfield
	@FindBy(xpath="//*[@id='1']")  
	WebElement phoneInput;
	
	//Locating submit button
	@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/form/button")
	public WebElement phnSubmit;
	
	//Locating the error message
	@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/span[2]")
	public WebElement errorMessage;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/div/header/div/div[1]/a/img")
	public WebElement logo;

	//Locating the otp message for validation
	@FindBy(xpath="//*[@id=\"mainContent\"]/div[9]/div/div[2]/p[1]")
	public WebElement otpFinder;
	
	By crossOtp=By.xpath("//*[@id=\"mainContent\"]/div[9]/div/div[1]/button");

	//Actions
	
	//Method for passing the wrong phone number and clicking on submit button
	public void enterWrongPhn(String mobilenumber) throws IOException {
		phoneInput.sendKeys(mobilenumber);
		phnSubmit.click();
	}
	
	//Method for passing the correct phone number and clicking on submit button
	public void enterCorrectPhn(String mobile) throws IOException {
		phoneInput.sendKeys(mobile);
		phnSubmit.click();
	}
	
	
	//Method for capturing the error message 
	public String captureErrorMessage() throws InterruptedException, IOException {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String errorMessageText=errorMessage.getText();
		System.out.println("\n"+errorMessageText+"\n");
		return errorMessageText;
	}
	
	//Method for clearing the Phone Number Textfield
	public void clear() {
		phoneInput.clear();
	}
	
	//method to cross/Off otp page
	public void crossOTP() {
		driver.findElement(crossOtp).click();
	}
	
}
