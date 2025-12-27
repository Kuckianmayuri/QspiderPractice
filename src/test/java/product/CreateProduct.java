package product;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.AddProductPage;
import config.baseClass;

@Listeners(listener.ListenerImplementation.class)
public class CreateProduct extends baseClass{
    
	@Test(priority = 1, groups = "smoke")
	 public void createProductRecord() throws EncryptedDocumentException, IOException  {
		// ==============================
		    // 🔹 Read data from Excel
		    // ==============================
		    String productName = elib.toReadDataFromExcel("Product", 1, 0) + jlib.getRandomNumber();
		    String productCategory = elib.toReadDataFromExcel("Product", 1, 1);
		    String productQuantity = elib.toReadDataFromExcel("Product", 1, 2);
		    String vendorID = elib.toReadDataFromExcel("Product", 1, 3);

		    // ==============================
		    // 🔹 Create New Product
		    // ==============================
		    home.getProductsLink().click();
		    AddProductPage productPage = new AddProductPage(driver);
		    productPage.getCreateProduct().click();

		    // Product Name
		    productPage.getProductName().sendKeys(productName);

		    // Product Category
		    WebElement categoryDropdown = productPage.getProductCategory();
		    categoryDropdown.click();
		    productPage.select(wUtil, "category", productCategory);

		    // Product Quantity
		    WebElement quantityField = productPage.getProductQuality();
		    quantityField.clear();
		    quantityField.sendKeys(productQuantity);

		    // Vendor ID
		    WebElement vendorDropdown = productPage.getProductVendorID();
		    vendorDropdown.click();
		    productPage.select(wUtil, "product", vendorID);

		    // Click Add Button
		    productPage.getCreateProductButton().click();

		    // ==============================
		    // 🔹 Validation (Toast Message)
		    // ==============================
		    WebElement toastMsg = home.getToastSuccessMsg();
		    wUtil.explicitlyWait(driver, toastMsg);

		    String msg = toastMsg.getText();
//		    if (msg.contains("Product")) {
//		        System.out.println("✅ Product created successfully!");
//		    } else {
//		        System.out.println("❌ Product creation failed!");
//		    }
		    Assert.assertEquals(msg, "Product "+productName+" Successfully Added");

		 
	 }
    
}
