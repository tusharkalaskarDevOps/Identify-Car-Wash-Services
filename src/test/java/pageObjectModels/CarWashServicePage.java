package pageObjectModels;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelUtils;

public class CarWashServicePage extends BasePage{
	//Declaring the variables
	public static List<String> carWashsingServices=new ArrayList<String>();
	public static List<String> customersRating=new ArrayList<String>();
	public static List<String> customersVotes=new ArrayList<String>();
	public static List<String> phoneNumbers=new ArrayList<String>();
	public static List<String> service_locations=new ArrayList<String>();
	
	//Constructor
	public CarWashServicePage(WebDriver driver) {
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath="//h3")
	public List<WebElement> serviceNames;
	
	@FindBy(xpath="//div[@role='button' and contains(@class,'greenfill_animate')]")
	public List<WebElement> phnBtn;
	
	@FindBy(xpath="//li[contains(@class,'resultbox_totalrate')]")
	public List<WebElement> rating;
	
	@FindBy(xpath="//li[contains(@class,'resultbox_countrate')]")
	public List<WebElement> votes;
	
	@FindBy(xpath="//*[@id=\"bd_call_popup\"]/div/div/div[1]")
	public WebElement skipMobilePopup;
	
	//
//	@FindBy(xpath ="*//span[@class='jsx-3349e7cd87e12d75 callcontent']")
//	public List<WebElement> phnText;
	@FindBy(xpath ="//*[@id=\"bd_call_popup\"]/div/div/div[2]/div[2]")
	public WebElement phnText;
	
	
	@FindBy(xpath="//*[contains(@class,'locatcity')]")
	List<WebElement> location_of_servises;
	
	@FindBy(xpath="//*[@id=\"filter_ul\"]/li[1]/button/div[1]")
	WebElement sortByBtn;
	
	@FindBy(xpath="//*[text()='Rating']")
	WebElement ratingBtn;
	
	//By Variables
	By serviceName=By.xpath("//h3");
//	By title_loc = By.xpath("//*[@id=\"__next\"]/section/section/div/div[2]/div/div[2]/h1");
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
			if(phnBtn.get(i).getText().equalsIgnoreCase("Show Number")) {
				phnBtn.get(i).click();
				
				WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait2.until(new ExpectedCondition<Boolean>() {

					@Override
					public Boolean apply(WebDriver driver) {
						String number =phnText.getText();
						return number.matches("[0-9]+");
					}
					
				});
				phoneNumbers.add(phnText.getText());
				skipMobilePopup.click();
			}else {
				phoneNumbers.add(phnBtn.get(i).getText());
			}
			
		}

		ExcelUtils.write_car_washing_data(carWashsingServices, phoneNumbers, customersRating, customersVotes);

		System.out.println("Service\t\t\t\tPhone Number\tRating\tVotes");
		System.out.println("------------------------------------------------------");
		for (int j = 0; j < 5; j++) {
		    System.out.println(
		        carWashsingServices.get(j) + "\t\t" +
		        phoneNumbers.get(j) + "\t" +
		        customersRating.get(j) + "\t" +
		        customersVotes.get(j)
		    );
		}
	}
	
	public void searchCarWashService(String location, String serach_text) throws IOException, InterruptedException {
		HomePage homePage=new HomePage(driver);
		homePage.locationSearch(location); //Giving Location Name in Search Input
		homePage.serviceSearch(serach_text); //Giving Service Name in Search Input
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean check_location(String location) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(serviceName));
		for(int i=0;i<5;i++) {
			service_locations.add(location_of_servises.get(i).getText());
			if(!location_of_servises.get(i).getText().contains(location)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkForAllFielsDataIsAvailable() {
		return !serviceNames.isEmpty();
	}
	
	
	public boolean isSortedOrNot() {
		List<String> sorted = new ArrayList<>(customersRating);
		Collections.sort(sorted);
		Collections.reverse(sorted);
		return customersRating.equals(sorted);
	}

	
}
