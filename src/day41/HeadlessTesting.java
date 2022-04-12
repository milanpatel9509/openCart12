package day41;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadlessTesting 
{
	WebDriver driver;
	
	@Test
	void heallessChrome() 
	{
		ChromeOptions option= new ChromeOptions();
		option.setHeadless(true);
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver= new ChromeDriver(option);
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	void heallessFirefox() 
	{
		FirefoxOptions option= new FirefoxOptions();
		option.setHeadless(true);
		
		System.setProperty("webdriver.gecko.driver","/Users/milanpatel9509gmail.com/Downloads/driver/geckodriver");
		driver= new FirefoxDriver(option);
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	void heallessEdge() 
	{
		EdgeOptions option= new EdgeOptions();
		option.setHeadless(true);
		
		System.setProperty("webdriver.edge.driver","/Users/milanpatel9509gmail.com/Downloads/driver/msedgedriver");
		driver= new EdgeDriver(option);
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}
