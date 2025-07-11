package driverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetup {
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
//		ChromeOptions options = new ChromeOptions();
		EdgeOptions options = new EdgeOptions();
		if(driver == null) {
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
		}
		
		
		
		return driver;
	}
}
