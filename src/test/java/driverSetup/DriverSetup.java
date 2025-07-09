package driverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		ChromeOptions options = new ChromeOptions();
		if(driver == null) {
			options.addArguments("--disable-blink-features=AutomationControlled");
			driver = new ChromeDriver(options);
		}
		
		
		return driver;
	}
}
