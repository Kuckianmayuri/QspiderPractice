package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String toReadDataFromExcel(String sheetname, int Rownum, int Cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data =wb.getSheet(sheetname).getRow(Rownum).getCell(Cellnum).getStringCellValue();
		return data;
		
	}
	public int toGetLastrowNum(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getFirstRowNum();
		return rowcount;
	}

}
