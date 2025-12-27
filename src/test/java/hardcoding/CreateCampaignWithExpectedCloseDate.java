package hardcoding;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;

public class CreateCampaignWithExpectedCloseDate {

    public static void main(String[] args) throws IOException {
        // -------------------- Utilities --------------------
        JavaUtility jlib = new JavaUtility();
        ExcelUtility elib = new ExcelUtility();
        PropertyUtility prib = new PropertyUtility();
        WebdriverUtility wUtil = new WebdriverUtility();

        // -------------------- Read data from property file --------------------
        String BROWSER = prib.toReadDataFromPropertiesFile("Browser");
        String URL = prib.toReadDataFromPropertiesFile("Url");
        String USERNAME = prib.toReadDataFromPropertiesFile("Username");
        String PASSWORD = prib.toReadDataFromPropertiesFile("Password");

        // -------------------- Read data from Excel --------------------
        String CAMPAIGNNAME = elib.toReadDataFromExcel("Campaign", 1, 1);
        String TARGET_SIZE = elib.toReadDataFromExcel("Campaign", 1, 3);
        System.out.println("Targeted size"+TARGET_SIZE);

        // -------------------- Get expected close date --------------------
        // Minimum allowed date = tomorrow
        String expectedDate = jlib.getExpectedDate(30);
        System.out.println("Expected Close Date: " + expectedDate);

        // -------------------- Initialize WebDriver --------------------
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // -------------------- Login --------------------
        LoginPage login = new LoginPage(driver);
        login.loginIntoApp(URL, USERNAME, PASSWORD);

        // -------------------- Navigate to Campaigns --------------------
        HomePage home = new HomePage(driver);
        home.getCampaignsLink().click();

        // -------------------- Create Campaign --------------------
        CampaignPage campaign = new CampaignPage(driver);
        campaign.getCreateCampaign().click();
        campaign.getCampaignNameTextField().sendKeys(CAMPAIGNNAME);

        WebElement targetSizeField = campaign.getTargetSizeTextField();
        targetSizeField.clear();
        targetSizeField.sendKeys(TARGET_SIZE);

        WebElement expDateField = campaign.getExpDateTextField();
        expDateField.clear();
        expDateField.sendKeys(expectedDate);

        // -------------------- Submit Campaign --------------------
        campaign.getCreateCampaignButton().click();

        // -------------------- Wait and validate toast message --------------------
        WebElement toastMsg = home.getToastSuccessMsg();
        wUtil.explicitlyWait(driver, toastMsg);

        String msg = toastMsg.getText();
        if (msg.contains(CAMPAIGNNAME)) {
            System.out.println("Campaign created successfully");
        } else {
            System.out.println("Campaign not created");
        }

        // -------------------- Logout --------------------
        WebElement profileIcon = home.getProfileIcon();
        wUtil.mouseHoverToWebElement(driver, profileIcon);
        home.getLogoutButton().click();

        // -------------------- Close Browser --------------------
        driver.quit();
    }
}
