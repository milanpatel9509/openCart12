package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAssignment 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement rome=driver.findElement(By.id("box6"));
		WebElement itly=driver.findElement(By.id("box106"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(rome, itly).build().perform();
		
		
		
		

	}

}
