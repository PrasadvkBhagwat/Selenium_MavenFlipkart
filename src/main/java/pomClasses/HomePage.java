package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.Util1;

public class HomePage extends Util1{

	
WebDriver driver;
	
	
	@FindBy(xpath="//div[text()='prasad']")
	private WebElement profileName;

	@FindBy(xpath="(//li[@class='_2NOVgj'])[1]")
	private WebElement MyProfileText;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean getProfileName() throws InterruptedException

	{
		Thread.sleep(1000);
		explicitWait(driver, profileName);
		String pName = profileName.getText();
		
		if(pName.equals("prasad"))
		{
			return true;
		}
			return false;	
	}

	public void moveToProfileName()
	{
		moveToElement(driver,profileName);
	}
	
	public void clickOnProfileText()
	{
		WebElement element = explicitWait(driver, MyProfileText);
		
		element.click();
	}
}
