package resources;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CheckoutPageObject;
import PageObjects.SelectCountryPageObject;
import PageObjects.ShoppingCartPageObject;

public class ShoppingCartTest extends Base {
	
	public WebDriver driver;
	public Logger logFile;
	
	@BeforeTest
		
	public void initialize() throws IOException
	{
		this.driver = initialiseDriver();
		this.logFile = super.logFile;
	}
	
	@Test
	public void shop() throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String [] products = {"Brocolli","Cucumber","Beetroot"};
		List<String> myList = Arrays.asList(products);
		
		ShoppingCartPageObject shopping = new ShoppingCartPageObject(driver);
		List <WebElement>productNamesList = shopping.getProductNamesList();
		SelectCountryPageObject finalPage = null;
		int j=0;
		for(int i=0;i<productNamesList.size();i++)
		{
			
			String name = productNamesList.get(i).getText();
			String []formattedNameArray = name.split("-");
			String formattedName = formattedNameArray[0].trim();
			
			if(myList.contains(formattedName))
			{
				Thread.sleep(4000);
				j++;
				shopping.getAddToCart().get(i).click();
				
				if(j==myList.size())
				{
					break;
				}
			}
		}
		Assert.assertEquals("123", "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
		shopping.clickAddToCart().click();
		CheckoutPageObject chkout = shopping.proceedTocheckout();
		chkout.promoCodeText().sendKeys("rahulshettyacademy");
		chkout.promoBtn().click();
		
		if(chkout.codeApplied().isDisplayed())
		{
			finalPage = chkout.placeOrder();
		}
		finalPage.selectCountry().selectByValue("India");
		finalPage.selectCheckBox().click();
		finalPage.clickProceedBtn().click();
		logFile.error("Test executed successfully.");
		
		driver.close();
	}

}
