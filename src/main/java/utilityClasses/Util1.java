package utilityClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util1 {

	public static WebElement explicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newElement = wait.until(ExpectedConditions.visibilityOf(element));
		return newElement;
	}
	
	public static String getProperty(String key) throws IOException	//	Pass parameter as key
	{
		FileInputStream file = new FileInputStream("configuration\\config.properties");		//	URL, UserName, Password	
		
		Properties pro = new Properties();		//	Read config.properties file
		
		pro.load(file);		//	Load config.properties
		
		String property = pro.getProperty(key);	//	Get data from config.peroperties file key --> URL, UserName, Password
		
		return property;
	}
	
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);		// We have to pass driver + that element
		act.moveToElement(element).perform();
	}
	
	
	public static void moveMouse(WebDriver driver)
	{
		Actions act = new Actions(driver);		// Change position of mouse
		act.moveByOffset(20,20).click().build().perform();
	}
}
