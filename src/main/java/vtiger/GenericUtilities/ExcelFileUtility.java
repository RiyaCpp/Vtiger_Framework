package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods to read data from excel file
 * @author Pranav
 *
 */
public class ExcelFileUtility 
{
	/**
	 * This method is used to read data from excel file and return value to the caller
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
  public String readdatafromexcelfile(String sheetname,int rownum,int cellnum) throws Throwable
  {
	  FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	  Workbook wb = WorkbookFactory.create(fise);
	  String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	  return data;
		 
  }
  
  /**
   * This method is used to write data to excel file
   * @param sheetname1
   * @param rowno
   * @param cellno
   * @param datas
   * @throws Throwable
   */
  public void writedatatoexcelfile(String sheetname1,int rowno,int cellno,String datas) throws Throwable
  {
	  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	  Workbook wb1 = WorkbookFactory.create(fis);
	wb1.createSheet(sheetname1).createRow(rowno).createCell(cellno).setCellValue(datas);
	FileOutputStream fose=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	wb1.write(fose);
	wb1.close();
  }
	 
 /**
  * This method will read multiple data from excel sheet for the sheet provided
  * @param sheetName
  * @return
  * @throws Throwable
  * @throws IOException
  */
  public Object[][] readmultipleDataFromExcel(String sheetName) throws Throwable, IOException
  {
	  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	  Workbook wb=WorkbookFactory.create(fis);
	  Sheet sh=wb.getSheet(sheetName);
	  int lastRow = sh.getLastRowNum();
	  int lastCol = sh.getRow(0).getLastCellNum();
	  
	  Object[][]data=new Object[lastRow][lastCol];
	  for(int i=0;i<lastRow;i++)
	  {
		  for(int j=0;j<lastCol;j++)
		  {
			  data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		  }
	  }
	  return data;
	  
  }
  }
  

