package DDT;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
         JSONParser jsonparse = new JSONParser();
         FileReader reader = new FileReader("src/main/resources/commondata.json");
         Object javaobj = jsonparse.parse(reader);
         JSONObject obj = (JSONObject)javaobj;
         String BROWSER = obj.get("Browser").toString();
         String URL = obj.get("Url").toString();
         String USERNAME = obj.get("Username").toString();
         String PASSWORD = obj.get("Password").toString();
         
         System.out.println(BROWSER);
         System.out.println(URL);
         System.out.println(USERNAME);
         System.out.println(PASSWORD);
         
         WebDriver driver = new ChromeDriver();

         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         //Open URL
         driver.get(URL);

         //Perform login using JSON values
         driver.findElement(By.id("username")).sendKeys(USERNAME);
         driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
         driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}

}
