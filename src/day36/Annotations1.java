package day36;

import org.testng.annotations.*;

public class Annotations1 {
	
	@BeforeMethod
	void login() 
	{
		System.out.println("Login...");
	}

	@Test(priority=1)
	void search()
	{
		System.out.println("search test");
	}

	@Test(priority=2)
	void advsearch() 
	{
		System.out.println("Adv Search test");
	}
	
	@AfterMethod
	void logout() 
	{
		System.out.println("logout....");
	}
	
}
