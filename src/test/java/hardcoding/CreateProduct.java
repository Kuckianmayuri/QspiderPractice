package hardcoding;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.AddProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;

public class CreateProduct {

    public static void main(String[] args) throws EncryptedDocumentException, IOException {
        
        // ==============================
        // 🔹 Initialize Utilities
        // ==============================
        JavaUtility jUtil = new JavaUtility();
        ExcelUtility eUtil = new ExcelUtility();
        PropertyUtility pUtil = new PropertyUtility();
        WebdriverUtility wUtil = new WebdriverUtility();

        // ==============================
        // 🔹 Read data from property file
        // ==============================
        String BROWSER = pUtil.toReadDataFromPropertiesFile("Browser");
        String URL = pUtil.toReadDataFromPropertiesFile("Url");
        String USERNAME = pUtil.toReadDataFromPropertiesFile("Username");
        String PASSWORD = pUtil.toReadDataFromPropertiesFile("Password");

        // ==============================
        // 🔹 Read data from Excel
        // ==============================
        String productName = eUtil.toReadDataFromExcel("Product", 1, 0) + jUtil.getRandomNumber();
        String productCategory = eUtil.toReadDataFromExcel("Product", 1, 1);
        String productQuantity = eUtil.toReadDataFromExcel("Product", 1, 2);
        String vendorID = eUtil.toReadDataFromExcel("Product", 1, 3);

        // ==============================
        // 🔹 Launch Browser
        // ==============================
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ==============================
        // 🔹 Login to Application
        // ==============================
        LoginPage login = new LoginPage(driver);
        login.loginIntoApp(URL, USERNAME, PASSWORD);

        // ==============================
        // 🔹 Navigate to Product Page
        // ==============================
        HomePage home = new HomePage(driver);
        home.getProductsLink().click();

        // ==============================
        // 🔹 Create New Product
        // ==============================
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
        if (msg.contains("Product")) {
            System.out.println("✅ Product created successfully!");
        } else {
            System.out.println("❌ Product creation failed!");
        }

        // ==============================
        // 🔹 Logout
        // ==============================
        WebElement profileIcon = home.getProfileIcon();
        wUtil.mouseHoverToWebElement(driver, profileIcon);
        home.getLogoutButton().click();

        // ==============================
        // 🔹 Close Browser
        // ==============================
        driver.quit();
    }
}
