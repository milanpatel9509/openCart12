package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		// total number of row
		int rows=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		System.out.println(rows);
		
		//total number of column
		int cols=driver.findElements(By.xpath("//table[@id='customers']//tr//th")).size();
		System.out.println(cols);
		
		//retriving each element
		for(int r=2;r<=rows;r++) {
			
			for(int c=1;c<=cols;c++) {
			String element=driver.findElement(By.xpath("//table[@id='customers']//tr["+r+"]//td["+c+"]")).getText();
			System.out.print(element+"   ");
			}
			System.out.println();
		}
		
		
	}

}
