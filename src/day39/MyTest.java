package day39;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(day39.MyListener.class)
public class MyTest {
	
	@Test(priority=1)
	void test1() 
	{
		System.out.println("it is test-1");
		Assert.assertEquals("A", "A");
	}
	
	@Test(priority=2)
	void test2() 
	{
		System.out.println("it is test-2");
		Assert.assertEquals("A", "B");
	}
	
	@Test(priority=3,dependsOnMethods={"test2"})
	void test3() 
	{
		System.out.println("it is test-3");
		Assert.assertEquals("A", "A");
	}

}
