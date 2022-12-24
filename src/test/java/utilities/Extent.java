package utilities;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.Scenario;

public class Extent {

	private static ExtentReports report;
	private static ExtentTest logger;

	static {
		report = new ExtentReports("/Users/almazbek/Desktop/report.html");
		logger = report.startTest("Runnig Smoke Test");
		logger.log(LogStatus.INFO, "Browser Started...");
	}
	
//	/**
//	 * Sets up the Extent Report.
//	 */
//	public static void setupExtent() {
//		report = new ExtentReports("/Users/almazbekbegaliev/Desktop/report.html");
//		logger = report.startTest("Runnig Smoke Test");
//		logger.log(LogStatus.INFO, "Browser Started...");
//	}

	
	public static void passTest(Scenario scenario) {
		logger.log(LogStatus.PASS, "Passed scenario: "+ scenario.getName());
	}

	
	public static void failTest(Scenario scenario) {
		WebDriver driver = Browser.getDriver();
			// Adding screenshot to the extent report
		logger.log(LogStatus.FAIL, "Failed scenario: "+ scenario.getName()+": ", logger.addScreenCapture(Screenshot.takeScreenshot()));
		
//		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// scenario.embed(screenshot, "image/png");
	}

	
	public static void flushExtent() {
		report.endTest(logger);
		report.flush();
	}

}
