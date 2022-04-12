package day39.extentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(day39.extentReports.ExtentReportManager.class)
public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() 
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void testLogo() 
	{
		try{
				boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
				Assert.assertEquals(status, true);
		}
		catch (Exception e)
		{
				Assert.fail();
		}
	}
	
	@Test(priority=2)
	void testLogin() 
	{
		try {  
			   driver.findElement(By.xpath("//a[text()='Log in']")).click();
			   Thread.sleep(2000);
			   
			   driver.findElement(By.id("Email")).sendKeys("xyz@gmail.com");
			   driver.findElement(By.id("Password")).sendKeys("test123");
			   driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
			   Thread.sleep(5000);
			   
			   boolean status=driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
			   System.out.println(status);
			   Assert.assertEquals(status, true);
		}
		catch (Exception e) 
		{
			   Assert.fail();
		}
	}
	
	@Test(priority=3,dependsOnMethods ={"testLogin"})
	void testLogout() throws InterruptedException 
	{
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(3000);
		
		boolean status=driver.findElement(By.linkText("Register")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@AfterClass
	void tearDown() 
	{
		driver.quit();
	}

}
