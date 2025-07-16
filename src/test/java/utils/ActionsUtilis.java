package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtilis {
	
	public static void clickENTER_btn(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER);
	}
	

	public static void scrollByAmount(WebDriver driver, int x, int y) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
	}

}
