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

public class HomePage extends BasePage{
	
	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//*[@id=\"loginPop\"]/div/div[2]/div/div[4]/a")
	WebElement popUp;
	@FindBy(xpath="//*[@id='city-auto-sug']")
	WebElement locationInput;
	
	@FindBy(xpath="//*[@id='react-autowhatever-city-auto-suggest--item-1']/a")
	public WebElement locationOpton;
	
	@FindBy(xpath="//*[@id='main-auto']")
	WebElement serviceInput;
	
	@FindBy(xpath="//*[@id=\"srchbtn\"]")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id=\"__next\"]/section/div[1]/a[1]")
	WebElement freeListing;
	
	//By variables
	By popup=By.xpath("//*[@id=\"loginPop\"]/div/div[2]/div/div[4]/a");
	
	By location=By.xpath("//*[@id='react-autowhatever-city-auto-suggest--item-1']/a");
	
	By sortBy=By.xpath("//*[@id=\"filter_ul\"]/li[1]/button/div[1]");
	
	
	//Actions
	public void closePopUp() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
		popUp.click();
	}
	
	public void locationSearch(String loc) throws IOException {
		locationInput.sendKeys(loc);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(location));
		locationOpton.click();
	}
	
	public void serviceSearch(String serach_text) throws IOException, InterruptedException {
		
		serviceInput.sendKeys(serach_text);
		searchBtn.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortBy));
	}
	
	public void openFreeListing() {
		freeListing.click();
	}
}
