package day18;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TitleComparisonDemo 
{

	/*
	 Assigment
	----------
	1) Open Web Browser(Chrome/firefox/IE).
	2) Open URL  https://admin-demo.nopcommerce.com/login
	3) Provide Email  (admin@yourstore.com).
	4) Provide password  (admin).   
	5) Click on Login.
	6) Capture title of the dashboad page.(Actual title)
	7) Verify title of the page: "Dashboard / nopCommerce administration" (Expected)
	8) close browser
	 
	 */
	static WebDriver driver;
	public static void main(String[] args) 
	{   
		System.out.println("please enter browser name: ");
		Scanner sc= new Scanner(System.in);
		String br=sc.next();
		
		selectBrowser(br);
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		
		WebElement email=driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		
		WebElement pwd=driver.findElement(By.name("Password"));
		pwd.clear();
		pwd.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String actTitle=driver.getTitle();
		String expTitle="Dashboard / nopCommerce administration";
		
		if(actTitle.equals(expTitle)) 
		{
			System.out.println("actual and expeted title are same");
		}
		else
		{
			System.out.println("actual and expeted title are not same");
		}
	}
	
	public static void selectBrowser(String browser) 
	{
		switch (browser) {
		case "chrome": System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
					   driver= new ChromeDriver();
					   break;
					   
		case "firefox":System.setProperty("webdriver.gecko.driver","/Users/milanpatel9509gmail.com/Downloads/driver/geckodriver");
					   driver= new FirefoxDriver();
					   break;	
					   
		case "edge":   System.setProperty("webdriver.edge.driver","/Users/milanpatel9509gmail.com/Downloads/driver/msedgedriver");
					   driver= new FirefoxDriver();
					   break;	
		
		case "safari":driver= new SafariDriver();			   
					  break;
					  
		default:System.out.println("Please enter valid browser name");
			    break;
		}
	}

}
