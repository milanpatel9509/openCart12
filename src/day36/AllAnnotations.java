package day36;

import org.testng.annotations.*;

public class AllAnnotations {

	@BeforeTest
	void bt() 
	{
		System.out.println("This is before test method");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("This is after test methos");
	}
	
	@BeforeClass
	void bc() 
	{
		System.out.println("This is before class");
	}
	
	@AfterClass
	void ac() 
	{
		System.out.println("This is after class");
	}
	
	@BeforeMethod
	void bm() 
	{
		System.out.println("This is before method");
	}
	
	@AfterMethod
	void am() 
	{
		System.out.println("This is after method");
	}
	
	@Test(priority=1)
	void search() 
	{
		System.out.println("search");
	}
	
	@Test(priority=2)
	void advsearch() 
	{
		System.out.println("adv search");
	}
}
