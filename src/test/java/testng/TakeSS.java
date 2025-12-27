package testng;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TakeSS {
	@Test
	public void sample() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Date date = new Date();
		System.out.println(date);
		String newdate = date.toString().replace(" ", "_").replace(":", "_");
		System.out.println(newdate);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./Screenshot/fb" + newdate + ".png");
		FileHandler.copy(temp, perm);
	}
}
