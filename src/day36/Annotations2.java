package day36;

import org.testng.annotations.*;

public class Annotations2 {
	
	@BeforeClass
	void login() 
	{
		System.out.println("login....");
	}
	
	@Test(priority=1)
	void search()
	{
		System.out.println("search test");
	}
	
	@Test(priority=2)
	void advsearch() 
	{
		System.out.println("adv search test");
	}
	
	@AfterClass
	void logout() 
	{
		System.out.println("logout...");
	}
}
