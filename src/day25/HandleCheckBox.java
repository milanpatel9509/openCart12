package day25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBox
{
	

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		
		//1). select single checkbox
		//driver.findElement(By.id("monday")).click();
		
		//2). select multiple checkbox
		List <WebElement>checkboxes = driver.findElements(By.className("form-check-input"));
		
		int checkboxesNo=checkboxes.size();
		System.out.println("Number of "+ checkboxesNo);
		
		for(WebElement box:checkboxes) 
		{	
		box.click();
		}
	}

}
