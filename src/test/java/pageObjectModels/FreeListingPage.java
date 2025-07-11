package pageObjectModels;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelUtils;
import utils.Screenshots;

public class FreeListingPage extends BasePage{
	//Declaring Variables
	public static String errorMessageText;
	
	//Constructor
	public FreeListingPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	//Locating PhoneNumber textfield
	@FindBy(xpath="//*[@id=\"1\"]")
	WebElement phoneInput;
	
	//Locating submit button
	@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/form/button")
	public WebElement phnSubmit;
	
	//Locating the error message
	@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/form/span[2]")
	public WebElement errorMessage;
	
	//By Variables to use in the explicit wait
	By errorMsg=By.xpath("//*[@id=\"listyourbusiness\"]/div[1]/form/span[2]");
	
	//Locating the otp message for validation
	@FindBy(xpath="//*[@id=\"mainContent\"]/div[9]/div/div[2]/p[1]")
	public WebElement otpFinder;
	
			
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		errorMessageText=errorMessage.getText();
		System.out.println("\n"+errorMessageText+"\n");
		return errorMessageText;
	}
	
	//Method for clearing the Phone Number Textfield
	public void clear() {
		phoneInput.clear();
	}
	
}
