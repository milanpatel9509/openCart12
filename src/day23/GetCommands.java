package day23;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommands
{

	public static void main(String[] args) 
	{	
		
		//1). browser open
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		//2). url
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//3) get title
		String title= driver.getTitle();
		System.out.println("title=====>"+title);
		
		//4). get current url
		String currentURL=driver.getCurrentUrl();
		System.out.println("current url=====>"+currentURL);
		
		//5). page source
		//String pageSource=driver.getPageSource();
		//System.out.println("page source=====>"+pageSource);
		
		//6). window id
		String windowID=driver.getWindowHandle();
		System.out.println("window id=====>"+windowID);
		
		//7). window ids
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windowIDs=driver.getWindowHandles();
		System.out.println("multiple window ID=====>"+windowIDs);
		
		driver.quit();

	}

}
