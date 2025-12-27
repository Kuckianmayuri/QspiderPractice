package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class threadPoolSize {
	@Test(invocationCount = 5, threadPoolSize = 2)
	public void sample() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		Reporter.log(title,true);
		driver.close();
	}
}
