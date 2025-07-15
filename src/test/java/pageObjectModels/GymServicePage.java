package pageObjectModels;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Screenshots;

public class GymServicePage extends BasePage{
	
	//Constructor
	public GymServicePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//*[@id=\"mainContent\"]/ul[2]/li[14]/a/div[1]")  
	public WebElement gymIcon;
	
	@FindBy(xpath="*//ul[@id=\"filter_ul\"]/li")
	public List<WebElement> gymSubMenu;

	@FindBy(xpath="//button[.//span[text()='Sort by']]")
	public WebElement sortBy;

	@FindBy(xpath = "//*[text()='Relevance']")
	public WebElement relevance;

	@FindBy(xpath = "//*[text()='Rating']")
	public WebElement sortByrating;

	@FindBy(xpath = "//address/div/div[2]")
	public List<WebElement> relevenceList;

	@FindBy(xpath="//nav/ul/li[2]/button")
	public WebElement amenitiesFilter;

	@FindBy(xpath="//li[@id='option-0']")
	public WebElement sundayAmenitiesFilter;

	@FindBy(xpath="//label[@for='Locker Facility']")
	public WebElement lockerAmenitiesFilter;

	@FindBy(xpath = "//li[text()='Locker Facility']")
	public List<WebElement> lockerList;

	@FindBy(xpath = "//button[text()='Apply']")
	public WebElement applyButton;

	@FindBy(xpath = "//div[text()='Clear']")
	public WebElement clearButton;

	@FindBy(xpath = "//button[.//span[text()='Open Now']]")
	public WebElement openNow;

	@FindBy(xpath = "//span[text()='Top Rated']")
	public WebElement topRated;

	@FindBy(xpath = "//button[.//span[text()='Quick Response']]")
	public WebElement quickResponse;

	@FindBy(xpath = "//button[.//span[text()='Jd Verified']]")
	public WebElement jdVerified;

	@FindBy(xpath = "//nav/ul/li[7]/button")
	public WebElement rating;

	@FindBy(xpath = "//li[@id='option-1']")
	public WebElement rating1;

	@FindBy(xpath = "//li[@id='option-2']")
	public WebElement rating2;

	@FindBy(xpath = "//li[@id='option-3']")
	public WebElement rating3;

	@FindBy(xpath = "//li[@role='presentation']")
	public List<WebElement> ratingCountList;

	@FindBy(xpath = "//button[.//span[text()='Deals']]")
	public WebElement deals;

	@FindBy(xpath = "//button[.//span[text()='Jd Trust']]")
	public WebElement jdTrust;

	@FindBy(xpath = "//button[.//span[@id='all_filters_btn']]")
	public WebElement allFilters;

	@FindBy(xpath = "//button[text()='Reset Filters']")
	public WebElement resetFilters;

	@FindBy(xpath = "//button[@id='side_menu_close']")
	public WebElement closeButton;


	//By Variables
	By submenu=By.xpath("*//ul[@id=\"filter_ul\"]/li");
	
	//Actions
	public void openApp() {
		driver.navigate().to("https://www.justdial.com/");
	}
	
	public void clickGymMenu() throws IOException {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", gymIcon);
		jse.executeScript("arguments[0].click();",gymIcon);
	}
	public void getSubmenu() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(submenu));
	}

}
