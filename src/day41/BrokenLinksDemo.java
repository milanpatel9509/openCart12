package day41;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenLinksDemo {

	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void testBrokenLinks() throws MalformedURLException 
	{
		//step1 : capture all the links
		// step2 : capture href attribute values of all the links
		//step3 : if href attribute doesnot have value--ignore it
		//step4 : if href attribute have value then conenct to the server usin the value(url)
		//step5: if error code <400  not a broken link  / if error code >=400 broken link
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("total links are:"+links.size());
		
		int brokenlinks=0;
		
		for(WebElement element:links)
		{
			String url=element.getAttribute("href");
						
			if(url == null || url.isEmpty())
			{
				System.out.println("URL is empty..");
				continue;
			}
			
			URL link= new URL(url);
			
			try
			{
				HttpURLConnection httpConn=(HttpURLConnection)link.openConnection();
				httpConn.connect(); // conenct to server
				
				if(httpConn.getResponseCode()>=400)
				{
					System.out.println(httpConn.getResponseCode()+url+" --- is broken link");
					brokenlinks++;
				}
				else
				{
					System.out.println(httpConn.getResponseCode()+" url "+" -- is Not broken link");
				}
			}
			catch(Exception e) {
				
			}
			
		}
		
		System.out.println("Number of broken links:"+brokenlinks );
		
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
