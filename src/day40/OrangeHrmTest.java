package day40;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHrmTest 
{
	WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	void setup() 
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=1)
	void test_logo() 
	{
		lp= new LoginPage(driver);
		Assert.assertEquals(lp.checkLogoPresence(),true);
	}
	
	@Test(priority=2)
	void test_login() 
	{
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickLogin();
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	
	@AfterClass
	void tearDown() 
	{
		driver.quit();
	}
}
