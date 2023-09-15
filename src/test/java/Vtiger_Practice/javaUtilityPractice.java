package Vtiger_Practice;

import vtiger.GenericUtilities.javaUtility;

public class javaUtilityPractice {

	public static void main(String[] args) 
	{
		javaUtility j=new javaUtility();
		int value = j.getRandomNumber();
		String dates = j.getSystemDate();
		System.out.println(value);
		System.out.println(dates);

	}

}
