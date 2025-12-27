package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	WebDriver driver;
	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create Campaign']")
    private WebElement createCampaign;
	
	@FindBy(name = "campaignName")
	WebElement campaignNameTextField;
	
	@FindBy(name = "campaignStatus")
	WebElement campaignStatusTextField;
	
	@FindBy(name = "targetSize")
	WebElement targetSizeTextField;
	
	@FindBy(name = "expectedCloseDate")
	WebElement expDateTextField;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	WebElement createCampaignButton;
	
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getCampaignStatusTextField() {
		return campaignStatusTextField;
	}

	public WebElement getTargetSizeTextField() {
		return targetSizeTextField;
	}

	public WebElement getExpDateTextField() {
		return expDateTextField;
	}

	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	
	
}

