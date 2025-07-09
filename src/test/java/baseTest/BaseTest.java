package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import driverSetup.DriverSetup;
import utils.ExcelUtils;

public class BaseTest {
	public static WebDriver driver;
	public static String baseUrl;
//	public static String fileName;
//	public static String sheetName;
	
	@BeforeClass
	public WebDriver setUpDriver() {
		
		Properties p =  new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\2407373\\OneDrive - Cognizant\\Documents\\HackThon_Project\\Identify-Car-Wash-Services\\src\\test\\resources\\config.properties");
			p.load(fis);
		}catch(Exception e) {
			
		}
		baseUrl = p.getProperty("url");
//		fileName = p.getProperty("file");
//		sheetName = p.getProperty("sheet");
		
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@DataProvider(name = "getDataForCarWashing")
	public String[][] getDataForCarWashing() throws IOException{
		String[][] data1 = ExcelUtils.readExcelForCarWashing();
		return data1;
	}
	
	@DataProvider(name = "getDataForFreeListing")
	public String[][] getDataForFreeListing() throws IOException{
		String[][] data2 = ExcelUtils.readExcelForFreeListing();
		return data2;
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}



		