package day33;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositeCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/milanpatel9509gmail.com/Downloads/driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String path="/Users/milanpatel9509gmail.com/Downloads/caldata.xlsx";  ///Users/milanpatel9509gmail.com/Downloads
		int rows=XLUtils.getRowCount(path,"Sheet1");
		
		for(int r=1;r<=rows;r++)
		{
			//Reading dara from exe data	
			
			String Princ=XLUtils.getCellData(path, "Sheet1", r, 0);	
			String roi=XLUtils.getCellData(path, "Sheet1", r, 1);	
			String Pre1=XLUtils.getCellData(path, "Sheet1", r, 2);	
			String Pre2=XLUtils.getCellData(path, "Sheet1", r, 3);	
			String fre=XLUtils.getCellData(path, "Sheet1", r, 4);
			String exp_mValue=XLUtils.getCellData(path, "Sheet1", r, 5);
		
			//entering data to the application
			driver.findElement(By.id("principal")).sendKeys(Princ);
			driver.findElement(By.id("interest")).sendKeys(roi);
			driver.findElement(By.id("tenure")).sendKeys(Pre1);
			
			Select sc1=new Select(driver.findElement(By.id("tenurePeriod")));
			sc1.selectByVisibleText(Pre2);
		
		
			Select sc2=new Select(driver.findElement(By.id("frequency")));
			sc2.selectByVisibleText(fre);
		
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='CTR PT15']/a[1]")).click();
			
		
			String act_mValue =driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
		
			if(Double.parseDouble(act_mValue)==Double.parseDouble(exp_mValue)) 
			{
				System.out.println("test passed");
				XLUtils.setCellData(path,"Sheet1",r,7,"Pass");
				XLUtils.fillGreenColor(path,"Sheet1",r,7);
			}
			else 
			{
				System.out.println("test fail");
				XLUtils.setCellData(path,"Sheet1",r,7,"Fail");
				XLUtils.fillRedColor(path,"Sheet1",r,7);
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
	
		}
		
		driver.quit();
		

	}

}
