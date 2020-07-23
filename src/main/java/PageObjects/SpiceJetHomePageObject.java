package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SpiceJetHomePageObject {
	
	private WebDriver driver;
	private By originDropDown = By.name("ctl00_mainContent_ddl_originStation1_CTXT");
	//private By originCity = By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//div[@id='dropdownGroup1']//*[@value='BLR']");
	
	private By originCity = By.xpath("//div[@id='dropdownGroup1']//div//ul//li//a");
	
	//private By destDropDown = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	//private By destCity = By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//*[@value='BOM']");
	private By destCity = By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a");
	
	//private By fromDate = By.id("ctl00_mainContent_view_date1");
	private By dates = By.xpath("//td[@data-month='7']//a[@class='ui-state-default']");
	private By passengers = By.id("divpaxinfo");
	private By adults = By.id("ctl00_mainContent_ddl_Adult");
	private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");
	
	
	public SpiceJetHomePageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getOriginDropDown()
	{
		return driver.findElement(originDropDown);
	}
	public List<WebElement> getOriginCity()
	{
		return driver.findElements(originCity);
	}
	
	public List<WebElement> getDestCity()
	{
		return driver.findElements(destCity);
	}
	
	public List<WebElement> getActualTravelDate()
	{
		return driver.findElements(dates);
	}
	
	public WebElement getNoOfPassengers()
	{
		return driver.findElement(passengers);
	}
	
	public Select selectNoOfAdults()
	{
		Select sel = new Select(driver.findElement(adults));
		return sel;
	}
	
	public WebElement searchFlights()
	{
		return driver.findElement(searchBtn);
	}

}
