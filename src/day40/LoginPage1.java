package day40;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 
{
	WebDriver driver;
	
	LoginPage1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='divLogo']//img")
	WebElement img_logo;
	
	@FindBy(id="txtUsername")
	WebElement username;	
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	
	public boolean checkLogoPresence()
	{
		boolean status=img_logo.isDisplayed();
		return status;
	}
	
	public void setUserName(String name) 
	{
		username.sendKeys(name);
	}
	
	public void setPassword(String pwd) 
	{
		password.sendKeys(pwd);
	}
	
	public void clickLogin() 
	{
		btn_login.click();
	}

}
