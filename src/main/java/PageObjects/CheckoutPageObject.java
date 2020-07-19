package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPageObject {
	
	WebDriver driver;
	WebDriverWait wait;
	private By promoCodeText = By.xpath("//*[@class='promoCode']");
	private By promoBtn = By.className("promoBtn");
	private By placeOrder = By.xpath("//button[text()='Place Order']");
	private By codeApplied = By.xpath("//*[text()='Code applied ..!']");
	
	public CheckoutPageObject(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebElement promoCodeText()
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		return driver.findElement(promoCodeText);
	}
	
	public WebElement promoBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		return driver.findElement(promoBtn);
	}
	
	public SelectCountryPageObject placeOrder()
	{
		SelectCountryPageObject country = new SelectCountryPageObject(driver);
		driver.findElement(placeOrder).click();
		return country;
	}
	
	public WebElement codeApplied()
	{
		
//This method will return the text "code applied" if it is displayed. But before that, it will wait for the text to be seen.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Code applied ..!']")));
		return driver.findElement(codeApplied);
	}

			
			

}
