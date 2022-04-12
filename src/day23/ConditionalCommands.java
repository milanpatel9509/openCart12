package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands
{

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		WebElement searchBox=driver.findElement(By.xpath("(//input[@id='small-searchterms'])"));
		System.out.println(searchBox.isDisplayed());
		System.out.println(searchBox.isEnabled());
		
		WebElement btn=driver.findElement(By.xpath("//input[@id='gender-male']"));
		
		System.out.println("before select radio button==========>");
		System.out.println(btn.isDisplayed());
		System.out.println(btn.isEnabled());
		System.out.println(btn.isSelected());
		
		
		System.out.println("after select radio button==========>");
		
		btn.click();
		System.out.println(btn.isDisplayed());
		System.out.println(btn.isEnabled());
		System.out.println(btn.isSelected());
	}

}
