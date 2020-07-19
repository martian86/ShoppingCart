package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPageObject {
	
	private WebDriver driver;
	private By productNames = By.className("product-name");
	private By addtocart = By.xpath("//*[text()='ADD TO CART']");
	private By cartIcon = By.xpath("//*[@class='cart-icon']");
	private By proceedToCheckout = By.xpath("//*[text()='PROCEED TO CHECKOUT']");
	
	public ShoppingCartPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public List<WebElement> getProductNamesList()
	{
		return driver.findElements(productNames);
	}
	
	public List<WebElement> getAddToCart()
	{
		return driver.findElements(addtocart);
	}
	
	public WebElement clickAddToCart()
	{
		return driver.findElement(cartIcon);
		
	}
	
	public CheckoutPageObject proceedTocheckout()
	{
		driver.findElement(proceedToCheckout).click();
		CheckoutPageObject chkout = new CheckoutPageObject(driver);
		return chkout;
	}

}
