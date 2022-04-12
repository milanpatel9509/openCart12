package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker1 
{

	public static void main(String[] args) throws InterruptedException 
	{	
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("datepicker")).click();
		
		String date="23";
		String month="September";
		String year="2023";
		
		while(true)
		{
			String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(mon.equals(month) && yr.equals(year)) 
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	
		}
		Thread.sleep(5000);
		
		List<WebElement> allDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele:allDate)
		{
			String dt=ele.getText();
			if(dt.equals(date))
			{
				Thread.sleep(2000);
				ele.click();
				break;
			}
		}
		
		
	}

}
