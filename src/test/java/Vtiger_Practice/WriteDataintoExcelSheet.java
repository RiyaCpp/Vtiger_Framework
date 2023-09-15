package Vtiger_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoExcelSheet {

	public static void main(String[] args) throws Throwable 
	{
		//Step 1: Open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to Sheet
		//Sheet sh = wb.getSheet("Organizations");
		
		//-- create new sheet
		Sheet sh=wb.createSheet("Trial");
		
		//Step 4: Navigate to Row
		//Row rw = sh.getRow(4);
		
		//--to create new Row
		Row rw=sh.createRow(7);
		
		//Step 5: Create a cell
		Cell cl = rw.createCell(5);
		
		//Step 6: Provide data to be written
		cl.setCellValue("SELENIUM");
		
		//Step 7: Open the document in Java write format
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 8: Write the data
		wb.write(fos);
		System.out.println("Data added successfully");
		
		//Step 9: Close
		wb.close();
		
		

	}

}
