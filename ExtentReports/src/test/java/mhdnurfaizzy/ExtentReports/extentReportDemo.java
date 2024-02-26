package mhdnurfaizzy.ExtentReports;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class extentReportDemo {
	
	ExtentReports extent;
	@BeforeTest
	public void config() {
		//Extent report, extentSparkReporter
		String path = System.getProperty("user.dir") + "//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Test Result");
		reporter.config().setDocumentTitle("Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Mhdnurfaizi");
	}
	
	@Test
	public void initialTest() {
		
		extent.createTest("Initial Demo");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.getTitle();
		extent.flush();
	}

}
