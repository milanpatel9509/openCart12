package day38;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class openCartDemo {
    WebDriver driver;
    
    @Parameters({"Browser","URL"})
    @BeforeMethod
	void setup(String browser,String url) throws InterruptedException
	{
		if(browser.contains("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
			driver= new ChromeDriver();
		}
		else if(browser.contains("edge"))
		{
			System.setProperty("webdriver.edge.driver","/Users/milanpatel9509gmail.com/Downloads/driver/msedgedriver");
			driver= new EdgeDriver();
		}
		else if(browser.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/milanpatel9509gmail.com/Downloads/driver/geckodriver");
			driver= new FirefoxDriver();
		}
		else if(browser.contains("safari"))
		{
			driver= new SafariDriver();
		}
		else
		{
			System.out.println("plese enter valid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get(url);
		Thread.sleep(5000);
	}
	
    
    @Test(priority = 1,dataProvider="dp")
    void Login(String email,String pwd) 
    {
    	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
    	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
    	driver.findElement(By.xpath("//input[@value='Login']")).click();
    	
    	String title=driver.getTitle();
    	Assert.assertEquals(title, "My Account","title are not match");
    }
	
    @DataProvider(name="dp")
    String[][] data()
    {
    	String[][] d= {
	    				   {"Yatin5431@gmail.com","12345"},
	    				   {"abc@gmail.com","123"},
	    				   {"xyz@gmail.com","abc"},
	    				   {"mno@gmail.com","pqr"}
    				   };
    	return d;
    }
	
    @AfterMethod
    void tearDown() 
    {
    	driver.quit();
    }
	
	
	
	
}
