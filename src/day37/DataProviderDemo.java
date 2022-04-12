package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() 
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider="dp")
	void  testLogin(String user,String pwd) throws InterruptedException 
	{
		
		driver.get("https://demo.nopcommerce.com/login");
		Thread.sleep(3000);
		driver.findElement(By.id("Email")).sendKeys(user);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		String act_title=driver.getTitle();
		String exp_title="nopCommerce demo store. Login";
		
		Assert.assertEquals(act_title, exp_title);
	}
	
	@DataProvider(name="dp")
	Object[][] LoginData()
	{
		String data[][]= { 
							{"pavanoltraining@gmail.com","test123"},
							{"pavanol@gmail.com","test@123"},
							{"pavanoltraining@gmail.com","test3"},
							{"pavanoltraining@gmail.com","test@123"},
							{"pavanoltraining@gmail.com","test@123"}
					  	 };
		return data;		
	}
	
	@AfterClass
	void tearDown() 
	{
		driver.quit();
	}
}
