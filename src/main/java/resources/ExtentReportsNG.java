package resources;

import java.security.PublicKey;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	ExtentReports extent;
	public ExtentReports getreport() {
		String path = System.getProperty("User.dir")+"\\reports\\index.html";
		ExtentSparkReporter repo = new ExtentSparkReporter(path);
		
		extent = new ExtentReports();
		extent.attachReporter(repo);
		
		return extent;
	}
}
