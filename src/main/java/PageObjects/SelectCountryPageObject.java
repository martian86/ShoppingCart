package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectCountryPageObject {
	
	WebDriver driver;
	private Select dropDown;
	private By selectVal = By.cssSelector("[class='wrapperTwo'] div select");
	private By iAgreeTnC = By.xpath("//*[@class='chkAgree']");
	private By proceedBtn = By.xpath("//*[text()='Proceed']");
	
	public SelectCountryPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public Select selectCountry()
	{
		dropDown = new Select(driver.findElement(selectVal));
		return dropDown;
	}
	
	public WebElement selectCheckBox()
	{
		return driver.findElement(iAgreeTnC);
	}
	
	public WebElement clickProceedBtn()
	{
		return driver.findElement(proceedBtn);
	}
	

}
