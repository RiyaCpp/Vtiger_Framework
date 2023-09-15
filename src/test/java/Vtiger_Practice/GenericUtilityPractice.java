package Vtiger_Practice;

import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable 
	{
		PropertyFileUtility util=new PropertyFileUtility();
		String s = util.readdatafrompropertyfile("url");
		System.out.println(s);

	}

}
