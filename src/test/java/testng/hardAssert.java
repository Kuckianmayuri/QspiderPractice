package testng;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class hardAssert {
	
	@Test
	public void sample() {
		String expectedResult ="facebook";
		WebDriver driver = new  ChromeDriver();
		driver. get("https://www.facebook.com/");
		String actualResult = driver.getTitle();
		System.out.println(actualResult);
		Assert.assertEquals(expectedResult, actualResult);
		System.out.println("step1 ");
		System.out.println("step2 ");
	}

}
