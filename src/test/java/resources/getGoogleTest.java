package resources;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class getGoogleTest extends Base {

	public Logger logFile;
	public WebDriver driver;
	@BeforeTest
	public void init() throws IOException
	{
		driver = initialiseDriver();
		this.logFile = super.logFile;
	}
	
	@Test
	public void getURL()
	{
		driver.get("https://www.google.com");
		logFile.info("Starting test to check google home page");
		Assert.assertEquals(driver.getTitle(), "Google");
		driver.close();
	}


}
