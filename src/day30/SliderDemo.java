package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement sliderLeft=driver.findElement(By.xpath("//span[1]"));
		
		Point coOrdinate=sliderLeft.getLocation();
		System.out.println("Co ordinate: "+coOrdinate.x);      
		System.out.println(coOrdinate);
		
		Thread.sleep(2000);
		
		Actions action= new Actions(driver);
		action.dragAndDropBy(sliderLeft, 100, 0).build().perform();
		 	  coOrdinate=sliderLeft.getLocation();
		System.out.println(coOrdinate);
		
		WebElement sliderRight=driver.findElement(By.xpath(" //span[2]"));
		
		System.out.println(sliderRight.getLocation());
		action.dragAndDropBy(sliderRight,-38, 0).perform();
		System.out.println(sliderRight.getLocation());
		
		
		

	}

}
