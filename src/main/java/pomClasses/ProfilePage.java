package pomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.Util1;

public class ProfilePage extends Util1{

	WebDriver driver;

	@FindBy(xpath="//div[@class='_1ruvv2']")
	private WebElement profileFullName;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddressText;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input")
	private List<WebElement> addressDetails;
	
	@FindBy(xpath="//textarea")
	private WebElement address;
	
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement saveAddress;
	
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> saveAddressCount;
	
	
	
	
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	// this is context
		this.driver = driver;
	}
	

	public boolean getFullProfileName()
	{
		WebElement element = explicitWait(driver, profileFullName);
		
		String fullName = element.getText();
		
		if(fullName.contains("Prasad"))
		{
			return true;
		}
			return false;
	}
	
	
	public void clickOnManageAddressText()
	{
		manageAddressText.click();
	}
	
	
	public void clickOnAddAddressText()
	{
		addAddressBtn.click();
	}
	
	
	public void fillAddressDetails()
	{
		String [] k = {"Samarth","7889809090","412308","HandeVadi","Pune"};
		
	
		for(int i=0; i<4; i++)
		{
			addressDetails.get(i).sendKeys(k[i]);
			
		}
	}
	

	
	public void fillMainAddress()
	{
		address.sendKeys("Shri Samarth Building, Rutuja Park, Pune");
	}
	
	
	public void clickOnSaveBtn()
	{
		saveAddress.click();
	}
	
	
	public int saveAddressCount()
	{
		return saveAddressCount.size();
	}
}
