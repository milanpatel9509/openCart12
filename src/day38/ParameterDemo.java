package day38;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParameterDemo {
	WebDriver driver;
	
	@Parameters({"Browser","URL"})
	@BeforeClass
	void setup(String browser,String appUrl) throws InterruptedException 
	{
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver=new ChromeDriver();
		}
	
		else if (browser.equals("edge")) {
		System.setProperty("webdriver.edge.driver","/Users/milanpatel9509gmail.com/Downloads/driver/msedgedriver");
		driver=new EdgeDriver();
		}
		
		else if (browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver","/Users/milanpatel9509gmail.com/Downloads/driver/geckodriver");
		driver=new FirefoxDriver();
		}
		
		else {
		System.out.println("Please enter valid browser");
		}
		
	
		driver.get(appUrl);
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	void testLogo()
	{
		try
		{
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		Assert.assertEquals(logo.isDisplayed(),true);
		System.out.println("first test sussfully done ");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	void testTitle()
	{
		Assert.assertEquals(driver.getTitle(),"OrangeHRM","Titles are not equal");
		System.out.println("second test sussfully done ");
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	

}
