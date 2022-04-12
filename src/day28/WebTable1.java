package day28;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();	
		
		//1). Number of rows in table
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of row: "+rows);
		
		//2). Number of cols in table
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
		System.out.println("Number of cols: "+cols);

		/*//3). Retriving specific element 
		String value =driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println(value);
		*/
		
		//4). Retriving each data
		for(int r=2;r<=rows;r++) 
			{
				for(int c=1;c<=cols;c++) 
				{
					String value =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
					System.out.print(value+"  ");
				}
				System.out.println();
			}
		
		//5). Print book names whose author is Amit
		for(int r=2;r<=rows;r++)
			{
				String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
				if(author.equals("Amit")) {
						String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
						System.out.println(bookName+"  "+author);
					}
			}
		
		//6). total price
		int sum=0;
		for(int r=2;r<=rows;r++)
			{
				String priceofEle= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
				int price=Integer.parseInt(priceofEle);
				sum = sum + price;
			}
		System.out.println("total price of book:"+sum);
		
		driver.quit();
	}

}
