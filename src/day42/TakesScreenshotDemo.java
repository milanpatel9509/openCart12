package day42;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TakesScreenshotDemo {

	WebDriver driver;
	@BeforeClass
	void setup() 
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void fullpagescreenshot() throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("./screenshot/fullpage.png");
		FileUtils.copyFile(src, trg);
	}
	
	@Test(priority=2)
	void specificelementscreenshot() throws IOException 
	{
		WebElement element=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src=element.getScreenshotAs(OutputType.FILE);
		File trg=new File("./screenshot/logo.png");
		FileUtils.copyFile(src, trg);
	}
	
	@Test(priority=3)
	void specificsectionscreenshot() throws IOException 
	{
	WebElement element=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
	File src=element.getScreenshotAs(OutputType.FILE);
	File trg=new File("./screenshot/section.png");
	FileUtils.copyFile(src, trg);
	}
	
	@AfterClass
	void tearDown() 
	{
		driver.quit();
	}
}
