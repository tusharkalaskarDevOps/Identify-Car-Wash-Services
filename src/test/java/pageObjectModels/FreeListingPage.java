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
	@FindBy(xpath="//*[@id=\"1\"]")
	WebElement phoneInput;
	
	@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/form/button")
	WebElement phnSubmit;
	
	@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/form/span[2]")
	public WebElement errorMessage;
	
	//By Variables
	By errorMsg=By.xpath("//*[@id=\"listyourbusiness\"]/div[1]/form/span[2]");
	
			
	//Actions
	
	public void enterWrongPhn(String mobilenumber) throws IOException {
		phoneInput.sendKeys(mobilenumber);
		phnSubmit.click();
	}
	
	public void captureErrorMessage() throws InterruptedException, IOException {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		errorMessageText=errorMessage.getText();
		System.out.println("\n"+errorMessageText+"\n");
		
	}
	
}
