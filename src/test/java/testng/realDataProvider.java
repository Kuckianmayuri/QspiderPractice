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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class realDataProvider {

    @DataProvider
    public Object[][] loginDetails() throws EncryptedDocumentException, IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\asus\\OneDrive\\Desktop\\weekendbatch.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");

        int rowCount = sh.getLastRowNum(); // last row index
        int colCount = sh.getRow(0).getLastCellNum(); // total columns

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) { // start from 1, since 0th row is header
            for (int j = 0; j < colCount; j++) {
                data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
            }
        }

        wb.close();
        fis.close();
        return data;
    }

    @Test(dataProvider = "loginDetails")
    public void loginProgram(String un, String pwd) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://49.249.28.218:8098/");

        driver.findElement(By.id("username")).sendKeys(un);
        driver.findElement(By.id("inputPassword")).sendKeys(pwd);

        // Optionally click login if there’s a button:
        // driver.findElement(By.id("loginButton")).click();

        driver.quit();
    }
}
