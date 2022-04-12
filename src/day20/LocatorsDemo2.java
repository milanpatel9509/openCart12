package day20;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo2
{

	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
	WebDriver driver= new ChromeDriver();
	
	driver.get("http://automationpractice.com/index.php");
   
	List<WebElement> sliders=driver.findElements(By.className("homeslider-container"));
	System.out.println("number of slider :"+sliders.size());
	
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("total links : "+links.size());
	
	List<WebElement> allImg=driver.findElements(By.tagName("img"));
	System.out.println("all img : "+allImg.size());
	
	driver.quit();
	}

}
