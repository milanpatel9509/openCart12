package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement sourse=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(sourse, target).build().perform();
		
		WebElement john=driver.findElement(By.xpath("//ul[@id='gallery']/li[1]"));
		WebElement mary=driver.findElement(By.xpath("//ul[@id='gallery']/li[2]"));
		WebElement trash=driver.findElement(By.id("trash"));
		
		act.dragAndDrop(john, trash).build().perform();
		act.dragAndDrop(mary, trash).build().perform();
		
	}

}
