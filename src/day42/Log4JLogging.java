package day42;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Log4JLogging
{
	WebDriver driver;
	Logger logger;
	
	@BeforeClass
	void setup() 
	{
		logger=LogManager.getLogger("Log4JLogging");
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
	}
	
	@Test
	void testRegistration() 
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		logger.info("Register link got clicked");
		
		driver.findElement(By.id("input-firstname")).sendKeys("JOHN");
		logger.info("Provided First Name");
		
		driver.findElement(By.id("input-lastname")).sendKeys("CANEDY");
		logger.info("Provided Last Name");
		
		driver.findElement(By.id("input-email")).sendKeys("xyzmno@gmail.com");
		logger.info("Provided Email");
		
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		logger.info("Provided Telephone");
		
		driver.findElement(By.id("input-password")).sendKeys("123xyz");
		logger.info("Provided Password");
		
		driver.findElement(By.id("input-confirm")).sendKeys("123xyz");
		logger.info("Provided Confirm Password");
		
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		logger.info("Agreed privacy policy");
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		logger.info("Continue link got clicked");
		
		logger.debug("Submitting data");
		
		String confmsg=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		logger.info("Confirmation message captured");
		
		if(confmsg.equals("Your Account Has Been Created!")) 
		{
			logger.info("Success: User Registered");
			Assert.assertTrue(true);
		}
		else 
		{
			logger.info("Success: User Not Registered");
			Assert.assertTrue(false);		
		}
		
		
		
	}
	

}
