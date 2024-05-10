package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass
{

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginBtn;
	
	public LoginPage() 
	{
		PageFactory.initElements(webDriver.get(),this);
	}
	
	public void enterusername()
	{
		username.sendKeys(null);
	}
	
	public void enterpassword() 
	{
		password.sendKeys(null);
	}
	
	public void clickOnloginBtn() 
	{
		loginBtn.click();
	}
}
