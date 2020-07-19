package resources;

import org.apache.logging.log4j.LogManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

public class ReporterObject {
	
	
	static ExtentReports extent;
	
	public static ExtentReports getReporterData()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();  //This is required Step.Else we get nullpointerException
		reporter.config().setReportName("My Own Test Suite");
		reporter.config().setDocumentTitle("My 123456");
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Aniruddha Parlikar");
		
		return extent;
	}

}
