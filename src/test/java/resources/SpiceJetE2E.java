package resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.SpiceJetHomePageObject;

public class SpiceJetE2E extends Base {
	
	public WebDriver driver;
	
	// Logger logFile = super.logFile;
	// This causes NullPointerException in Listener. So we have to declare the logFile in another way.
	
	//We explicitly declare logFile in this way when we use dataProvider annotation.
	public Logger logFile = LogManager.getLogger(Base.class.getName());
	
	/* Commenting this because in dataProvider annotation, driver is getting initialized only for the first set of values.
	 * so for the other set of input values, browser is not opening, because we are using driver.close() method
	
	@BeforeTest
	public void init() throws IOException
	{
		
		this.driver = initialiseDriver();
		this.logFile = super.logFile;
	}*/
	
	@Test(dataProvider = "getSourceDestCityfromDB")
	public void bookTickets(String source, String destination) throws InterruptedException, IOException
	{
		this.driver = initialiseDriver();
		
		driver.get("https://www.spicejet.com/default.aspx");
		Thread.sleep(2000);


		/*
		String source = "Bengaluru";
		String destination = "Mumbai";*/
		SpiceJetHomePageObject spiceJetPage = new SpiceJetHomePageObject(driver);
		
		spiceJetPage.getOriginDropDown().click();
		
		
		for(int i=0;i<spiceJetPage.getOriginCity().size();i++)
		{
			if(spiceJetPage.getOriginCity().get(i).getText().contains(source))
					{
						spiceJetPage.getOriginCity().get(i).click();
						break;
					}
		}
		
		for(int i=0;i<spiceJetPage.getDestCity().size();i++)
		{
			if(spiceJetPage.getDestCity().get(i).getText().contains(destination))
					{
						spiceJetPage.getDestCity().get(i).click();
						break;
					}
		}
		
		spiceJetPage.getActualTravelDate().get(17).click();
		spiceJetPage.getNoOfPassengers().click();
		spiceJetPage.selectNoOfAdults().selectByValue("4");
		spiceJetPage.searchFlights().click();
		
		driver.close();
		
	}
	
	
	@DataProvider
	public String[][] getSourceDestCityfromDB() throws SQLException
	{
		String host = "localhost:";
		String port = "3306";
		String databaseName = "demo";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + port + "/" + databaseName, "root", "admin");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from cities;");
		
		
		
		int rowCount = 0;
		int colCount = rs.getMetaData().getColumnCount();
		while(rs.next())
		{
			rowCount++;
		}
		
		rs.first();
		
		String[][] data =  new String[rowCount][colCount];
		System.out.println(rowCount);
		System.out.println(colCount);
		
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				data[i][j] = rs.getString(j+1);
			}
			rs.next();
		}
		con.close();
		return data;
	}
	

}
