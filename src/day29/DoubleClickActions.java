package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickActions 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		driver.switchTo().frame("iframeResult");
		
		WebElement field1=driver.findElement(By.id("field1"));
		field1.clear();
		field1.sendKeys("It's Milan Patel");
		
		WebElement btn=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		
		
		
		Actions act=new Actions(driver);
		act.doubleClick(btn).build().perform();
		
		WebElement field2=driver.findElement(By.id("field2"));
		
		if(field2.getAttribute("value").equals("It's Milan Patel")) 
		{
			System.out.println("test pass");
		}
		else 
		{
			System.out.println("test fail");
		}
		
		

	}

}
