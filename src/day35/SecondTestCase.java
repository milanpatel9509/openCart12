package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SecondTestCase {
	
	WebDriver driver;
	
	@Test (priority=1)
	void openApp()
	{
		 System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		 driver=new ChromeDriver();
		 driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@Test (priority=2)
	void login()
	{
		WebElement emailTxt=driver.findElement(By.xpath("//input[@id='Email']"));
		emailTxt.clear();
		emailTxt.sendKeys("admin@yourstore.com");
		
		WebElement passTxt=driver.findElement(By.xpath("//input[@id='Password']"));
		passTxt.clear();
		passTxt.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		String act_lbl=driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
		
		//Assert.assertEquals(act_lbl, "Dashboard");
		
		if(act_lbl.equals("Dashboards")) 
		{
			System.out.println("test passed");
			Assert.assertTrue(true);
		}
		else 
		{
			System.out.println("test failed");
			Assert.assertTrue(false,"lable are not match");
		}
	}
	
	@Test (priority=3)
	void closeApp() 
	{
		driver.close();
	}

}
