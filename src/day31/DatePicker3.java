package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker3 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		Select selectDep=new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		selectDep.selectByVisibleText("Boston");
		
		
		Select selectArv=new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		selectArv.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[2]")).click();
		
		driver.findElement(By.id("inputName")).sendKeys("Mike");
		
		driver.findElement(By.id("address")).sendKeys("Canada");
		
		driver.findElement(By.id("city")).sendKeys("Toronto");
		
		driver.findElement(By.id("state")).sendKeys("ON");
		
		driver.findElement(By.id("zipCode")).sendKeys("A1B 2C4");
		
		Select selectCard= new Select(driver.findElement(By.id("cardType")));
		selectCard.selectByVisibleText("American Express");
		
		
		driver.findElement(By.id("creditCardNumber")).sendKeys("1234 5678 9012 3456");
		
		driver.findElement(By.id("creditCardMonth")).sendKeys("01");
		
		driver.findElement(By.id("creditCardYear")).sendKeys("2015");
		
		driver.findElement(By.id("nameOnCard")).sendKeys("Mike D");
		
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		
		
		

	}

}
