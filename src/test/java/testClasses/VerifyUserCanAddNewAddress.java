package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass1;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.ProfilePage;

public class VerifyUserCanAddNewAddress {

	
	static WebDriver driver;
	HomePage hp;
	ProfilePage pp;

	@BeforeClass
	public void beforeClass() throws IOException
	{
		driver = BaseClass1.getDriver("chrome");
	}
	  
	@BeforeMethod
	public void beforeMethod() 
	{
		 hp = new HomePage(driver);
	}
	
	@Test
	public void verifyUserCanGoToProfilePage()
	{
		hp.moveToProfileName();
		hp.clickOnProfileText();
		hp.moveMouse(driver);
		
		pp = new ProfilePage(driver);
		
		Assert.assertTrue(pp.getFullProfileName());
				
	}
	
	@Test(priority =1)	//	It will run after the verifyUserCanGoToProfilePage method
	public void verifyUserCanAddAddress() throws InterruptedException
	{
		
		
		pp.clickOnManageAddressText();
	
		int previousAddressCount = pp.saveAddressCount();
		System.out.println(previousAddressCount);
		 
		pp.clickOnAddAddressText();
		pp.fillAddressDetails();
		pp.fillMainAddress();
		pp.clickOnSaveBtn();
		
		Thread.sleep(1000);
		int currentAddressCount = pp.saveAddressCount();
		
		Assert.assertEquals(currentAddressCount, previousAddressCount + 1);	
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		
	}
	
	
	@AfterClass
	public void afterClass()
	{
		
	}
}
