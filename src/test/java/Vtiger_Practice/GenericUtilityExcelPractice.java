package Vtiger_Practice;

import vtiger.GenericUtilities.ExcelFileUtility;

public class GenericUtilityExcelPractice {

	public static void main(String[] args) throws Throwable 
	{
		ExcelFileUtility ef=new ExcelFileUtility();
		String value = ef.readdatafromexcelfile("Contacts", 1, 2);
		System.out.println(value);
		
		ef.writedatatoexcelfile("NewTrial",2, 3, "Harry POtter");
		System.out.println("Data written successfully");

	}

}
