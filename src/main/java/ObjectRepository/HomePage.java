package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profileIcon;

	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement toastSuccessMsg;

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getToastSuccessMsg() {
		return toastSuccessMsg;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

}
