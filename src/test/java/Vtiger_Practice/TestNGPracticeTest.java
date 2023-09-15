package Vtiger_Practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
 
	@Test(enabled = false)
  
  public void createcontact()
  {
	  System.out.println("create");
  }
  
	
	@Test(priority=1)
  public void modifycontact()
  {
	  System.out.println("modify");
  }
  
	@Test
  public void Deletecontact()
  {
	  System.out.println("Delete");
  }
}
