package day37;

import org.testng.annotations.Test;

public class GroupingDemo {

	/*
	loginByEmail  - sanity & regression
	loginByfacebook - sanity
	loginBytwitter  - sanity

	signupbyemail - sanity & regression
	signupbyfacebook  - regression
	signupbytwitter  - regression

	paymentinrupees - sanity & regression
	paymentindollar - sanity  
	paymentReturnbyBank  - regression
	*/
	@Test (priority=1)
	void loginByEmail() 
	{
		System.out.println("this is login by email");
	}
	
	@Test (priority=2,groups="sanity", dependsOnMethods= {"loginByEmail"})
	void loginByfacebook() 
	{
		System.out.println("this is login by facebook");
	}
	
	void loginBytwitter() 
	{
		System.out.println("this is login by twitter");
	}
	
	void signupByemail() 
	{
		System.out.println("this is sign up by email");
	}
	
	void signupbyfacebook() 
	{
		System.out.println("this is sign up by facebook");
	}
	
	void signupbytwitter()
	{
		System.out.println("this is sign up by twitter");
	}
	
	void paymentinrupees()
	{
		System.out.println("this is payment in rupees");
	}
	
	void paymentindollar() 
	{
		System.out.println("this is payment in dollar");
	}
	
	void paymentReturnbyBank() 
	{
		System.out.println("this is payment return by bank");
	}
}
