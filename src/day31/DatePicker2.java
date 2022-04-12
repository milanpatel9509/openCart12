package day31;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker2 
{

	public static void main(String[] args) throws InterruptedException
	{
		String date="23";
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.findElement(By.id("departon")).click();
		
		WebElement year=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selectYear=new Select(year);
		selectYear.selectByVisibleText("2021");
		
		Thread.sleep(2000);
		WebElement month=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selectMonth=new Select(month);
		selectMonth.selectByVisibleText("Sep");
	
		
		List<WebElement> allDate =driver.findElements(By.xpath("//a[contains(@class,'ui-state-default')]"));  ////a[contains(@class,'ui-state-default')]
	
		
		for(WebElement e :allDate) 
		{
			String dt=e.getText();
			if(dt.equals(date)) 
			{
				
				e.click();
				
			}
		}
		
		
	}

}
