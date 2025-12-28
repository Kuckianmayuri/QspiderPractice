package testCasesTestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;


import ObjectRepository.CampaignPage;
import config.baseClass;

@Listeners(listener.ListenerImplementation.class)
public class CreatecampaignTest extends baseClass {
	/**
	 * @author Mayuri
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	@Test(priority = 1, groups = {"smoke","Regression", "campaign"})
	public void createCampaignwithMandatoryField() throws EncryptedDocumentException, IOException {
		String CAMPAIGNNAME = elib.toReadDataFromExcel("Campaign", 1, 2);
		String TARGET_SIZE = elib.toReadDataFromExcel("Campaign", 1, 3);
		// -------------------- Create Campaign --------------------
		 home.getCampaignsLink().click();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateCampaign().click();
		campaign.getCampaignNameTextField().sendKeys(CAMPAIGNNAME);

		WebElement targetSizeField = campaign.getTargetSizeTextField();
		targetSizeField.clear();
		targetSizeField.sendKeys(TARGET_SIZE);

		// -------------------- Submit Campaign --------------------
		campaign.getCreateCampaignButton().click();

		// -------------------- Wait and validate toast message --------------------
		WebElement toastMsg = home.getToastSuccessMsg();
		wUtil.explicitlyWait(driver, toastMsg);

		String msg = toastMsg.getText();
//		if (msg.contains(CAMPAIGNNAME)) {
//			System.out.println("Campaign created successfully");
//		} else {
//			System.out.println("Campaign not created");
//		} 
		Assert.assertEquals(msg, "Campaign "+CAMPAIGNNAME+" Successfully Added");
	}
	
	@Test(priority = 2, groups = {"smoke", "campaign"})
	public void createCampaignwithStatus() throws EncryptedDocumentException, IOException {
         
		String CAMPAIGNNAME = elib.toReadDataFromExcel("Campaign", 1, 1);
		String TARGET_SIZE = elib.toReadDataFromExcel("Campaign", 1, 3);
		String STATUS = elib.toReadDataFromExcel("Campaign", 1, 4);
		home.getCampaignsLink().click();

		// -------------------- Create Campaign --------------------
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateCampaign().click();
		campaign.getCampaignNameTextField().sendKeys(CAMPAIGNNAME);

		WebElement targetSizeField = campaign.getTargetSizeTextField();
		targetSizeField.clear();
		targetSizeField.sendKeys(TARGET_SIZE);

		campaign.getCampaignStatusTextField().sendKeys(STATUS);

		// -------------------- Submit Campaign --------------------
		campaign.getCreateCampaignButton().click();

		// -------------------- Wait and validate toast message --------------------
		WebElement toastMsg = home.getToastSuccessMsg();
		wUtil.explicitlyWait(driver, toastMsg);

		String msg = toastMsg.getText();
//		if (msg.contains(CAMPAIGNNAME)) {
//			System.out.println("Campaign created successfully");
//		} else {
//			System.out.println("Campaign not created");
//		}
		Assert.assertEquals(msg, "Campaign "+CAMPAIGNNAME+" Successfully Added");

	}
	@Test(priority = 3, groups = {"Regression", "campaign"})
	 public void createCampaignwithExpecteddate() throws EncryptedDocumentException, IOException {
		 String CAMPAIGNNAME = elib.toReadDataFromExcel("Campaign", 1, 1);
			String TARGET_SIZE = elib.toReadDataFromExcel("Campaign", 1, 3);
			String expectedDate = jlib.getExpectedDate(30);
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
//	        if (msg.contains(CAMPAIGNNAME)) {
//	            System.out.println("Campaign created successfully");
//	        } else {
//	            System.out.println("Campaign not created");
//	        }
	       Assert.assertEquals(msg, "Campaign "+CAMPAIGNNAME+" Successfully Added");
	      System.out.println("campaign testcases ran successfully");
	 }
}

