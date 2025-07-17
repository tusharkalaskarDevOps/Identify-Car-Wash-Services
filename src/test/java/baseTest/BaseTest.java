package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ExcelUtils;

public class BaseTest {
	public static WebDriver driver;
	public static String baseUrl;
	
	@BeforeTest
	@Parameters({"os","browser","execution_env"})
	public WebDriver setUpDriver(String os, String browser, String execution_env) {
		
		Properties p =  new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			p.load(fis);
		}catch(Exception e) {
			
		}
		baseUrl = p.getProperty("url");
		
		if(execution_env.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabalities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
				return null;
			}
			//browser
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-blink-features=AutomationControlled");
//				option.addArguments("--disable-notifications");
				capabalities.setBrowserName("chrome");
				capabalities.setCapability(ChromeOptions.CAPABILITY, option);
			}
			else if(browser.equalsIgnoreCase("edge")) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--disable-blink-features=AutomationControlled");
//				option.addArguments("--disable-notifications");
				capabalities.setBrowserName("MicrosoftEdge");
				capabalities.setCapability(EdgeOptions.CAPABILITY, option);
				
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
//			    options.addPreference("dom.webnotifications.enabled", false); // Disable notifications
			    options.addArguments("--disable-blink-features=AutomationControlled"); // Similar to Edge's automation control
			    capabalities.setBrowserName("firefox");
			    capabalities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
			}



			else {
				System.out.println("no matching browser .....");
			}
			 try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444") , capabalities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		else if(execution_env.equalsIgnoreCase("local")) {
			
			
			//driver=new ChromeDriver(option);
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-blink-features=AutomationControlled");
				option.addArguments("--disable-notifications");
				driver = new ChromeDriver(option);
//				logger.info("Chrome browser opened successfully");
			}
			else if(browser.equalsIgnoreCase("edge")){
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--disable-blink-features=AutomationControlled");
				option.addArguments("--disable-notifications");
				driver = new EdgeDriver(option);
//				logger.info("Edge browser opened successfully");
			}
			else {
				System.out.println("no matching browser......");
//				logger.info("no matching browser......");
				return null;
			}
		}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	
	
	@DataProvider(name = "getDataForCarWashing")
	public static String[][] getDataForCarWashing() throws IOException{
		String[][] data1 = ExcelUtils.readExcelForCarWashing();
		return data1;
	}
	
	@DataProvider(name = "getDataForFreeListing")
	public String[][] getDataForFreeListing() throws IOException{
		String[][] data2 = ExcelUtils.readExcelForFreeListing();
		return data2;
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}



		