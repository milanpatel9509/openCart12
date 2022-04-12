package day40;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{	
	//webdriver instance
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	//locators
	By img_logo=By.xpath("//div[@id='divLogo']//img");
	By txt_usename=By.id("txtUsername");
	By txt_password=By.id("txtPassword");
	By btn_login=By.id("btnLogin");
	
	//Action steps/method
	public boolean checkLogoPresence() 
	{
		boolean status=driver.findElement(img_logo).isDisplayed();
		return status;
	}
	
	public void setUserName(String name) 
	{
		driver.findElement(txt_usename).sendKeys(name);
	}
	
	public void setPassword(String pwd) 
	{
		driver.findElement(txt_password).sendKeys(pwd);
	}
	
	public void clickLogin() 
	{
		driver.findElement(btn_login).click();
	}
}
