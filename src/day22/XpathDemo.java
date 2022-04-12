package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo 
{

	public static void main(String[] args)
	{	// browser open
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		// url 
		driver.get("http://automationpractice.com/index.php");
		
		// maximize window
		driver.manage().window().maximize();
		
		/*
		 // absolute xpath
		 driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]")).sendKeys("T-Shirts");
		 driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();
		 */
		 
		/*
		// relative xpath
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("T-Shirts");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		*/
		
		/*
		// xpath with multiple attributes
		driver.findElement(By.xpath("//input[@id='search_query_top'][@name='search_query']")).sendKeys("Shirt");
		driver.findElement(By.xpath("//button[@type='submit'][@name='submit_search']")).click();
		*/
		
		
		// xpath with text()
		driver.findElement(By.xpath("//a[text()='Women']")).click();
		String mobile=driver.findElement(By.xpath("//*[text()='0123-456-789']")).getText();
		System.out.println(mobile.equals("0123-456-789")?"Pass test Case":"fail Test Case");
		
		
		// xpath using or operator
		
		// xpath using and operator
		
		// xpath using contains(@attributes,'value')
		
		// xpath using starts-with(@attributes,'value')
	}
}
