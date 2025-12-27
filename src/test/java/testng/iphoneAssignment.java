package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class iphoneAssignment {

	@DataProvider
    public Object[][] iphoneData() throws EncryptedDocumentException, IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\asus\\OneDrive\\Desktop\\IphoneAssignment.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");

        int rowCount = sh.getLastRowNum(); 
       // int colCount = sh.getRow(0).getLastCellNum(); 

        Object[][] data = new Object[rowCount][2];

        for (int i = 0; i < rowCount; i++) { 
//            for (int j = 0; j < ; j++) {
                data[i][0] = sh.getRow(i + 1).getCell(0).getStringCellValue();
                data[i][1] = sh.getRow(i+1).getCell(1).getStringCellValue();
            //}
        }

        wb.close();
        //fis.close();
        return data;
    }
	
	   @Test(dataProvider = "iphoneData")
	    public void loginProgram(String mobileBrand, String iphoneVersion) {
	        WebDriver driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.get("https://www.amazon.in/");
	       // System.out.println(iphoneVersion+" "+iphoneBrand);
            WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
            search.sendKeys(mobileBrand);
            search.submit();
            WebElement priceElement = driver.findElement(By.xpath("//span[contains(text(),'"+iphoneVersion+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[3]//div[1]//div[@data-cy='price-recipe']//span[@class='a-price']"));
            String price = priceElement.getText();
            System.out.println("iPhone: " + iphoneVersion + " | Price: " + price);
            driver.quit();
	    }
}
