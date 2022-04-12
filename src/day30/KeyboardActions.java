package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		WebElement text1=driver.findElement(By.id("inputText1"));
		text1.sendKeys("Its Milan Patel Software Engineer");
		
		//driver.manage().deleteAllCookies();
		
		Actions act=new Actions(driver);
		
		act.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
		Thread.sleep(2000);
		
		act.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
		Thread.sleep(2000);
		
		act.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		act.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
		Thread.sleep(2000);
		
		
		
	}

}
