package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IfEIse {

	@Test
	public void sample() {
		// TODO Auto-generated method stub

		String expectedResult ="factbook";
		WebDriver driver = new  ChromeDriver();
		driver. get("https://www.facebook.com/");
		String actualResult = driver.getTitle();
		System.out.println(actualResult);
		if(expectedResult.equals(actualResult)) {
			System.out.println("tetscase pass");
		}else {
			System.out.println("tetscase fail");
		}
		
	}

}
