package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtilis {
	
	public static void clickENTER_btn(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER);
	}
	
	public static void scrollTo(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele);
	}
}
