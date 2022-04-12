package day33;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CItBankCalculator {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		String path="/Users/milanpatel9509gmail.com/Downloads/caldata2.xlsx";
		int rows=XLUtils.getRowCount(path,"Sheet1");
				
		
		for(int r=1; r<=rows;r++) 
		{
			//readind data
			
			String deposite=XLUtils.getCellData(path,"Sheet1", r,0);
			String roi=XLUtils.getCellData(path,"Sheet1", r,1);
			String months=XLUtils.getCellData(path,"Sheet1", r,2);
			String compounding=XLUtils.getCellData(path,"Sheet1", r,3);
			String totals=XLUtils.getCellData(path,"Sheet1", r,4);
			
			
			WebElement ed=driver.findElement(By.id("mat-input-0"));
			WebElement er=driver.findElement(By.id("mat-input-2"));
			WebElement em=driver.findElement(By.id("mat-input-1"));
			
			ed.clear();
			er.clear();
			em.clear();
			
			
			ed.sendKeys(deposite);
			er.sendKeys(roi);
			em.sendKeys(months);
			
			
			WebElement compoundrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));   
			compoundrp.click();
			
			List<WebElement> list=driver.findElements(By.xpath("//div[@role='listbox']//span"));
			for(WebElement e:list) {
				if(e.getText().equals(compounding)) 
				{
					e.click();
					break;
				}
			}
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div")).click();
			
			
			Thread.sleep(2000);
			
			String actValue=driver.findElement(By.id("displayTotalValue")).getText();
			
			if(actValue.equals(totals))
					{
					System.out.println("pass");
					XLUtils.setCellData(path,"Sheet1", r,6,"passed");
					XLUtils.fillGreenColor(path,"Sheet1", r,6);
				
					}
			else
					{
					System.out.println("fail");
					XLUtils.setCellData(path,"Sheet1", r,6,"fail");
					XLUtils.fillRedColor(path,"Sheet1", r,6);
					}
				
		}	

	}
}
