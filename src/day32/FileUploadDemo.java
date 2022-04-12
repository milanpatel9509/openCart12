package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadDemo
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		Actions action= new Actions(driver);
		
		WebElement pim=driver.findElement(By.id("menu_pim_viewPimModule"));
		WebElement addEmp=driver.findElement(By.id("menu_pim_addEmployee"));
		
		action.moveToElement(pim).perform();
		action.moveToElement(addEmp).click().perform();
		
		driver.findElement(By.id("photofile")).sendKeys("/Users/milanpatel9509gmail.com/Desktop/India.png");
		
		
		

	}

}
