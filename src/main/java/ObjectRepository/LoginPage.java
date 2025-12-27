package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	  PageFactory.initElements(driver, this);
	}
	
        
	@FindBy(id = "username")
	private WebElement userNameTestField;
	
	@FindBy(id = "inputPassword")
	private WebElement PasswordTextField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;
	
	public WebElement getUserNameTestField() {
		return userNameTestField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}
	
	public void loginIntoApp(String URL, String USERNAME, String PASSWORD) {
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.get(URL);
       getUserNameTestField().sendKeys(USERNAME);
       getPasswordTextField().sendKeys(PASSWORD);
       getSignInButton().click();
	}
}
