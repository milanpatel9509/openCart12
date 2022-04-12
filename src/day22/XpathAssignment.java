package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAssignment {

	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		int numOfLinks= driver.findElements(By.tagName("a")).size();
		System.out.println("total number of link on page: "+numOfLinks);
		
		List<WebElement> imgLocator=driver.findElements(By.tagName("img"));
		System.out.println("total number of imgage on page: "+imgLocator.size());
		
		driver.findElement(By.xpath("//input[@id='small-searchterms' and @type='text']")).sendKeys("Nokia Lumia 1020");
		
		driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
		

	}

}
