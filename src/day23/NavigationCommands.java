package day23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands
{

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		
		driver.get("https://www.facebook.com/");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		driver.quit();
		
	}

}
