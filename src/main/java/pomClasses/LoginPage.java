package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.Util1;

public class LoginPage extends Util1{
	
	WebDriver driver;
	
	 
	//WebElements	
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginBtn;
	
	
	//constructor
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	//public methods
	
	public void enterEmail() throws IOException
	{
		emailField.sendKeys(getProperty("UserName"));
	}
	
	
	public void enterPassword() throws IOException
	{
		passwordField.sendKeys(getProperty("Password"));
	}
	
	
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
}
