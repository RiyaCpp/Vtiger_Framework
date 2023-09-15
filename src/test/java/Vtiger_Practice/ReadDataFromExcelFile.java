package Vtiger_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable
	{
		//Step 1: Open the document in Java Readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required Sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//Step 4: Navigate to required Row
		Row rw = sh.getRow(1);
		
		//Step 5: Navigate to required Cell
		Cell cl = rw.getCell(2);
		
		//Step 6: Read the data inside the cell
		String data = cl.getStringCellValue();
		System.out.println(data);
		
		//Step 7: Close the Workbook
		wb.close();
	}

}
