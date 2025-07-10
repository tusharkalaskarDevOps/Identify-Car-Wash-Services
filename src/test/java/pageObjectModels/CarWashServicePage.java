package pageObjectModels;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Screenshots;

public class CarWashServicePage extends BasePage{
	//Declaring the variables
	public static List<String> carWashsingServices=new ArrayList<String>();
	public static List<String> customersRating=new ArrayList<String>();
	public static List<String> customersVotes=new ArrayList<String>();
	public static List<String> phoneNumbers=new ArrayList<String>();
	
	//Constructor
	public CarWashServicePage(WebDriver driver) {
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath="//h3")
	List<WebElement> serviceNames;
	
	@FindBy(xpath="//div[@role='button' and contains(@class,'greenfill_animate')]")
	List<WebElement> phnBtn;
	
	@FindBy(xpath="//li[contains(@class,'resultbox_totalrate')]")
	List<WebElement> rating;
	
	@FindBy(xpath="//li[contains(@class,'resultbox_countrate')]")
	List<WebElement> votes;
	
	//
	@FindBy(xpath ="*//span[@class='jsx-3349e7cd87e12d75 callcontent']")
	List<WebElement> phnText;
	
	
	
	@FindBy(xpath="//*[@id=\"filter_ul\"]/li[1]/button/div[1]")
	WebElement sortByBtn;
	
	@FindBy(xpath="//*[text()='Rating']")
	WebElement ratingBtn;
	
	//By Variables
	By serviceName=By.xpath("//h3");
	
	//Actions
	public void getCarWashingServiceandPhone() throws InterruptedException, IOException {
		sortByBtn.click();
		ratingBtn.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(serviceName));
		for(int i=0;i<5;i++) {
			carWashsingServices.add(serviceNames.get(i).getText());
			customersVotes.add(votes.get(i).getText());
			customersRating.add(rating.get(i).getText());
//			phnBtn.get(i).click();
		}
		for(int j=0;j<5;j++) {
//			phoneNumbers.add(phnText.get(j).getText());
			System.out.println("\n"+carWashsingServices.get(j)+"--------"+customersRating.get(j)+"----"+customersVotes.get(j));
		}
	}
	
}
