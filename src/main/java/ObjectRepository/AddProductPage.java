package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class AddProductPage {

	WebDriver driver;

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement createProduct;

	@FindBy(name = "productName")
	private WebElement productName;

	@FindBy(name = "productCategory")
	private WebElement productCategory;

	@FindBy(name = "quantity")
	private WebElement productQuality;

	@FindBy(name = "price")
	private WebElement productPrice;

	@FindBy(name = "vendorId")
	private WebElement productVendorID;

	@FindBy(name = "productCategory")
	WebElement productDropdown;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement createProductButton;

	public WebElement getProductDropdown() {
		return productDropdown;
	}

	public WebElement getCreateProduct() {
		return createProduct;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getProductQuality() {
		return productQuality;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getProductVendorID() {
		return productVendorID;
	}

	public WebElement getCreateProductButton() {
		return createProductButton;
	}

//	public void selectProduct(WebdriverUtility wItil, String nameOfDropdown) {
//		wItil.selectDropDownByVisibleText(productDropdown, nameOfDropdown);
//	}
//
//	public void selectVendorID(WebdriverUtility wItil, String nameOfDropdown) {
//		wItil.selectDropDownByVisibleText(productVendorID, nameOfDropdown);
//	}
	public void select(WebdriverUtility wUtil, String dropDownType, String nameOfDropdown)
	{
		if(dropDownType.equalsIgnoreCase("category")) {
			wUtil.selectDropDownByVisibleText(productCategory, nameOfDropdown);
		}
		else if(dropDownType.equalsIgnoreCase("Product")) {
			wUtil.selectDropDownByVisibleText(productVendorID, nameOfDropdown);
		}
		else {
			System.out.println("❌ Invalid dropdown type: " + dropDownType);
		}
	}

}
