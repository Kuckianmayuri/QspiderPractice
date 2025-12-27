package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataBackToExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       FileInputStream fis = new FileInputStream("src/main/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Campaign");
		Row row = sh.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellValue("pass");
		FileOutputStream fos = new FileOutputStream("src/main/resources/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
