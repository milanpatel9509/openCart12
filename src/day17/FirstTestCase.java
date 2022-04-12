package day17;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
/*
 * 	Test Case
	-------------
	1) Open Web Browser(Chrome/firefox/Edge).
	2) Open URL  https://opensource-demo.orangehrmlive.com/
	3) Enter username  (Admin).
	4) Enter password  (admin123).  
	5) Click on Login.
	6) Capture title of the home page.(Actual title) 
	7) Verify title of the page: OrangeHRM    (Expected)
	8) close browser
 */
public class FirstTestCase
{
	
    static WebDriver driver;
    
	public static void main(String[] args) throws InterruptedException
	{
		//selct browser
		System.out.println("plese enter browserName: ");
		Scanner sc=new Scanner(System.in);
		String br=sc.next();
     	selectBrowser(br.trim());
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		//open url
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//enter username
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		//enter password
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		
		//click on login
		driver.findElement(By.id("btnLogin")).click();
		
		//capture tile
		String actualTitle=driver.getTitle();
		String expetedTitle="OrangeHRM";
		
		//verified title
		if(actualTitle.equals(expetedTitle)) 
		{
			System.out.println("expected tile and actual title are same");
		}
		else
		{
			System.out.println("expected tile and actual title are not same");
		}
		
		//close driver
		driver.quit();
		
	}
	
	
   public static void selectBrowser(String browser) 
   {
	   if(browser.contains("chrome")||browser.equalsIgnoreCase("chrome")) 
	   {
		   System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		   driver= new ChromeDriver();  
	   }
	   else if(browser.equals("edge")) 
	   {
		   System.setProperty("webdriver.edge.driver","/Users/milanpatel9509gmail.com/Downloads/driver/msedgedriver");
		   driver= new EdgeDriver();  
	   }
	   else if(browser.equals("firefox")) 
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
		   System.out.println("plese enter valid browser name");
	   }
   }
}
