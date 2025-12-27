package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void selectDropDownByIndex(WebElement we,int index)
	{
		Select sel = new Select(we);
		sel.selectByIndex(index);
	}
	public void selectDropDownByVisibleText(WebElement we,String visibleText)
	{
		Select sel = new Select(we);
		sel.selectByVisibleText(visibleText);
	}
	
	public void mouseHoverToWebElement(WebDriver driver, WebElement we) {
		Actions act = new Actions(driver);
		act.moveToElement(we).click().perform();
	}
	
	public void explicitlyWait(WebDriver driver,WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	
}
