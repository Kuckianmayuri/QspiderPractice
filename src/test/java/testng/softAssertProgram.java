package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertProgram {

	@Test
	public void sample() {
		String expectedResult ="facebook";
		WebDriver driver = new  ChromeDriver();
		driver. get("https://www.facebook.com/");
		String actualResult = driver.getTitle();
		System.out.println(actualResult);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expectedResult, actualResult);
		System.out.println("step1 ");
		System.out.println("step2 ");
		soft.assertAll();
	}
}
