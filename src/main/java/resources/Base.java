package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
public class Base {

	public WebDriver driver;
	public Logger logFile;

	public WebDriver initialiseDriver() throws IOException
	{
		String basePath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(new File(basePath + "\\property.properties"));
		Properties props = new Properties();
		props.load(fis);
		logFile = LogManager.getLogger(Base.class.getName());
		
		String browser = props.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\aniru\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\aniru\\Documents\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\aniru\\Documents\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static String getScreenshot(WebDriver driver, String failedTest) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\Screenshots\\"+failedTest+".jpg";
		FileUtils.copyFile(src, new File(destFile));
		return destFile;
	}
	
	
}
