package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingWebpage 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		//js.executeScript("window.scrollBy(0,3000)");
		
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		WebElement flag=driver.findElement(By.xpath("//img[@alt='Flag of India']"));
		
		js.executeScript("arguments[0].scrollIntoView();", flag);
		

	}

}
