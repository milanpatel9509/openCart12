package day35;

import org.testng.annotations.Test;

/*
 * Test Case
 * -----------
 * 1). Open App
 * 2). Login
 * 3). Logout
 * 4). Close App
 * 
 * 
 */


public class FirstTestCase {
	
	@Test
	void closeApp()
	{
		System.out.println("closing application...");
	}
	
	@Test
	void openApp()
	{
		System.out.println("opening application...");
	}
	
	@Test
	void logout()
	{
		System.out.println("logout application...");
	}
	
	@Test
	void login()
	{
		System.out.println("login application...");
	}
	
	
	
	
	

}
