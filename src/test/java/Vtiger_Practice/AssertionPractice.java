package Vtiger_Practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice
{

	//Hard Assert --- for critical and mandatory features
	
	@Test
	 public void test()
	 {
		 System.out.println("Test Started");
		 Assert.assertEquals("a", "b");
		 System.out.println("Iam here");
	 }
	
	@Test
	public void test2()
	{
		SoftAssert sa=new SoftAssert();
		
		System.out.println("Step 1");
		//sa.assertEquals(1, 2);
		Assert.assertEquals(true, false);
		System.out.println("Step 2");
		//sa.assertAll();
		sa.assertTrue(false);
	//	sa.assertFalse(false);
		System.out.println("Step 3");
		sa.assertEquals(1, 2);
		System.out.println("Step 4");
		sa.assertAll();
		
	}
	
	
}
