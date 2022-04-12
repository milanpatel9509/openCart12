package day41;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CookiesDemo 
{
	WebDriver driver;
	
	@BeforeClass
	void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void testCookies() 
	{
		//(1) how to get all cookies
		
		Set<Cookie> allCookies=driver.manage().getCookies();
		System.out.println("Total number of cookies:"+allCookies.size());
		for(Cookie e:allCookies)
		{
			System.out.println(e.getName()+" : "+e.getValue());
		}
		
		//(2) how to add new cookie:
		Cookie cookieobj=new Cookie("Mycookie","123456");
		driver.manage().addCookie(cookieobj);

		
		
		Cookie c =new Cookie("Milan Patel","Software Engineer");
		driver.manage().addCookie(c);
		allCookies=driver.manage().getCookies();
		System.out.println("total number cookies after add: "+allCookies.size());
		
		//(3) how to delete cookie By object variable name:
		
		driver.manage().deleteCookie(c);
		System.out.println(allCookies.size());
		allCookies=driver.manage().getCookies();
		System.out.println("total number cookies after add: "+allCookies.size());
		
		//(4) how to delete cookie by cookie name
		driver.manage().deleteCookieNamed(".Nop.Customer ");
		allCookies=driver.manage().getCookies();
		System.out.println("total number cookies : "+allCookies.size());
		
		//(5) how to delete all cookies
		driver.manage().deleteAllCookies();
		allCookies=driver.manage().getCookies();
		System.out.println("total number cookies after all cookies delete: "+allCookies.size());

	}
	
	@AfterClass
	void tearDown() 
	{
		
	}
	

}
